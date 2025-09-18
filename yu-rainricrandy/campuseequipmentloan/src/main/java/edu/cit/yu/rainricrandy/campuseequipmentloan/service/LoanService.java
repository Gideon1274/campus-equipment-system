package edu.cit.yu.rainricrandy.campuseequipmentloan.service;

import edu.cit.yu.rainricrandy.campuseequipmentloan.DTO.LoanDTO;
import edu.cit.yu.rainricrandy.campuseequipmentloan.model.*;
import edu.cit.yu.rainricrandy.campuseequipmentloan.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Service
public class LoanService {

//    private final LoanRepository loanRepo;
//    private final StudentRepository studentRepo;
//    private final EquipmentRepository equipmentRepo;
    private final PenaltyCalculator penaltyCalculator;

    private final StudentRepository studentRepo;
    private final EquipmentRepository equipmentRepo;
    private final LoanRepository loanRepo;

    public LoanService(PenaltyCalculator penaltyCalculator, StudentRepository studentRepo, EquipmentRepository equipmentRepo, LoanRepository loanRepo) {
        this.penaltyCalculator = penaltyCalculator;
        this.studentRepo = studentRepo;
        this.equipmentRepo = equipmentRepo;
        this.loanRepo = loanRepo;
    }

    public Loan createLoan(LoanDTO loanDTO) {
        Student student = studentRepo.findById(loanDTO.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Equipment equipment = equipmentRepo.findById(loanDTO.getEquipmentId())
                .orElseThrow(() -> new RuntimeException("Equipment not found"));

        Loan loan = new Loan();
        loan.setStudent(student);
        loan.setEquipment(equipment);
        loan.setStartDate(loanDTO.getStartDate());
        loan.setDueDate(loanDTO.getDueDate());
        loan.setReturnDate(loanDTO.getReturnDate());
        loan.setStatus(LoanStatus.valueOf(loanDTO.getStatus()));

        return loanRepo.save(loan);
    }


    @Transactional
    public BigDecimal returnLoan(Long loanId) {
        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        loan.setReturnDate(LocalDate.now());
        loan.setStatus(LoanStatus.RETURNED);

        Equipment equipment = loan.getEquipment();
        equipment.setAvailability(true);
        equipmentRepo.save(equipment);

        loanRepo.save(loan);

        return penaltyCalculator.calculatePenalty(loan);
    }

    public List<Equipment> getAvailableEquipment() {
        return equipmentRepo.findByAvailabilityTrue();
    }
}

package edu.cit.yu.rainricrandy.campuseequipmentloan.controller;

import edu.cit.yu.rainricrandy.campuseequipmentloan.DTO.LoanDTO;
import edu.cit.yu.rainricrandy.campuseequipmentloan.model.Equipment;
import edu.cit.yu.rainricrandy.campuseequipmentloan.model.Loan;
import edu.cit.yu.rainricrandy.campuseequipmentloan.model.LoanStatus;
import edu.cit.yu.rainricrandy.campuseequipmentloan.model.Student;
import edu.cit.yu.rainricrandy.campuseequipmentloan.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/loans")
    public ResponseEntity<Loan> createLoan(@RequestBody LoanDTO loanDTO) {
        Loan savedLoan = loanService.createLoan(loanDTO);
        return ResponseEntity.ok(savedLoan);
    }



    @PostMapping("/loans/{id}/return")
    public ResponseEntity<Map<String, Object>> returnLoan(@PathVariable Long id) {
        BigDecimal penalty = loanService.returnLoan(id);
        Map<String, Object> response = new HashMap<>();
        response.put("penalty", penalty);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/equipment/available")
    public List<Equipment> listAvailableEquipment() {
        return loanService.getAvailableEquipment();
    }
}

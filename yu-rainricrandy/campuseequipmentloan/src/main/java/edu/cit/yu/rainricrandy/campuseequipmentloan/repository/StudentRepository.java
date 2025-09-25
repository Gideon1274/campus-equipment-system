package edu.cit.yu.rainricrandy.campuseequipmentloan.repository;

import edu.cit.yu.rainricrandy.campuseequipmentloan.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentNo(String studentNo);
}
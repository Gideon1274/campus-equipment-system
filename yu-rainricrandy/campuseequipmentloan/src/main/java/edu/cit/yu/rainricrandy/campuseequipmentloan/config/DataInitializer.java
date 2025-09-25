package edu.cit.yu.rainricrandy.campuseequipmentloan.config;

import edu.cit.yu.rainricrandy.campuseequipmentloan.model.Student;
import edu.cit.yu.rainricrandy.campuseequipmentloan.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        System.out.println("DataInitializer: Checking for test user");
        if (studentRepository.findByStudentNo("test").isEmpty()) {
            System.out.println("DataInitializer: Creating test user");
            Student testUser = new Student();
            testUser.setStudentNo("test");
            testUser.setName("Test User");
            testUser.setEmail("test@example.com");
            testUser.setPassword(passwordEncoder.encode("1234"));
            testUser.setRoles(List.of("USER"));
            studentRepository.save(testUser);
        } else {
            System.out.println("DataInitializer: Test user exists");
        }
    }
}
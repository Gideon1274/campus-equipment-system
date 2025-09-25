package edu.cit.yu.rainricrandy.campuseequipmentloan.service;

import edu.cit.yu.rainricrandy.campuseequipmentloan.model.Student;
import edu.cit.yu.rainricrandy.campuseequipmentloan.repository.StudentRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Attempting to load user: " + username);
        Optional<Student> student = studentRepository.findByStudentNo(username);
        if (student.isPresent()) {
            System.out.println("User found: " + student.get().getStudentNo());
        } else {
            System.out.println("User not found: " + username);
        }
        return student.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public Student register(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setRoles(List.of("USER"));
        return studentRepository.save(student);
    }
}
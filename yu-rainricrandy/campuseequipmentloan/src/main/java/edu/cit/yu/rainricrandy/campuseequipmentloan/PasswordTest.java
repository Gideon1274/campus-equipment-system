package edu.cit.yu.rainricrandy.campuseequipmentloan;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "1234";
        System.out.println("Encoded: " + encoder.encode(rawPassword));
    }
}
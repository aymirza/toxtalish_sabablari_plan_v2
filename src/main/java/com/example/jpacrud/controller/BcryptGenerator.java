package com.example.jpacrud.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptGenerator {
    public static void main(String[] args) {

        int i = 0;
        while (i < 5) {
            String password = "12";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);

            System.out.println(hashedPassword);
            i++;
        }

    }
}

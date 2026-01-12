package com.proteccion.santiagomarin.pruebatecnica.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DefaultPasswordParser {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("Pa$$word123!"));
    }
}

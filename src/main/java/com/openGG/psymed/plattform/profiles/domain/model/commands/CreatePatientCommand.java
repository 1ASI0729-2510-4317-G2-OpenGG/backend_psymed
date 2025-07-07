package com.openGG.psymed.plattform.profiles.domain.model.commands;

import java.time.LocalDate;

public record CreatePatientCommand(String name, String lastName, String dni, String email, String phone, LocalDate birthDate) {

    public CreatePatientCommand {
        // Evitar que sea vacio
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Patient name cannot be null or empty");
        }
        if(lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Patient last name cannot be null or empty");
        }
        if(dni == null || dni.isBlank()) {
            throw new IllegalArgumentException("Patient dni cannot be null or empty");
        }
        if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if(phone == null || phone.isBlank()){
            throw new IllegalArgumentException("Patient phone cannot be null or empty");
        }
        if(birthDate == null){
            throw new IllegalArgumentException("Patient birth date cannot be null or empty");
        }
        // Evitar que pase el limite de caracteres
        if(name.length() > 50) {
            throw new IllegalArgumentException("Patient name cannot exceed 50 characters");
        }
        if(lastName.length() > 50) {
            throw new IllegalArgumentException("Patient last name cannot exceed 50 characters");
        }
        if(dni.length() > 10) {
            throw new IllegalArgumentException("Patient dni cannot exceed 10 characters");
        }
        if(email.length() > 100) {
            throw new IllegalArgumentException("Patient email cannot exceed 100 characters");
        }
        if(phone.length() > 15) {
            throw new IllegalArgumentException("Patient phone cannot exceed 10 characters");
        }
        if (birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birth date cannot be in the future");
        }
    }
}
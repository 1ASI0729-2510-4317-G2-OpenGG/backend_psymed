package com.openGG.psymed.plattform.profiles.domain.model.commands;

public record CreateMedicCommand(String name, String lastName, String email, String phone, String specialty, String address) {

    public CreateMedicCommand {
        //Si la información está vacía o no cumple el formato
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Medic name cannot be null or empty");
        if(lastName == null || lastName.isBlank())
            throw new IllegalArgumentException("Medic last name cannot be null or empty");
        if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            throw new IllegalArgumentException("Invalid email format");
        if(phone == null || phone.isBlank())
            throw new IllegalArgumentException("Medic phone cannot be null or empty");
        if(specialty == null || specialty.isBlank())
            throw new IllegalArgumentException("Medic specialty cannot be null or empty");
        if(address == null || address.isBlank())
            throw new IllegalArgumentException("Medic address cannot be null or empty");
        //Si la información excede al limite de caracteres de un medico
        if(name.length() > 50)
            throw new IllegalArgumentException("Medic name cannot exceed 50 characters");
        if(lastName.length() > 50)
            throw new IllegalArgumentException("Medic last name cannot exceed 50 characters");
        if(email.length() > 100)
            throw new IllegalArgumentException("Medic email cannot exceed 100 characters");
        if(phone.length() > 15)
            throw new IllegalArgumentException("Medic phone cannot exceed 15 characters");
        if(specialty.length() > 50)
            throw new IllegalArgumentException("Medic specialty cannot exceed 50 characters");
        if(address.length() > 50)
            throw new IllegalArgumentException("Medic address cannot exceed 50 characters");
    }
}
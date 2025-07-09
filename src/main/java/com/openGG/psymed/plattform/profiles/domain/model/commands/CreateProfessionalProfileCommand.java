package com.openGG.psymed.plattform.profiles.domain.model.commands;

public record CreateProfessionalProfileCommand(String firstName, String lastName, String street, String city, String country, String email, String username, String password) {

}

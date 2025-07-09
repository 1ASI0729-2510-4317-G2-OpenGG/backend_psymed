package com.openGG.psymed.plattform.iam.interfaces.rest.resources;

//TODO: In the future I will add the token here
public record AuthenticatedAccountResource(Long id, String role, String token) {
}

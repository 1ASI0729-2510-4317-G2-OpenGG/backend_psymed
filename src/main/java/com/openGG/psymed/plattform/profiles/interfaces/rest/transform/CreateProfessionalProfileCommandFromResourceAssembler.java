package com.openGG.psymed.plattform.profiles.interfaces.rest.transform;

import com.openGG.psymed.plattform.profiles.domain.model.commands.CreateProfessionalProfileCommand;
import com.openGG.psymed.plattform.profiles.interfaces.rest.resources.CreateProfessionalProfileResource;

public class CreateProfessionalProfileCommandFromResourceAssembler {
    public static CreateProfessionalProfileCommand toCommandFromResource(CreateProfessionalProfileResource resource) {
        return new CreateProfessionalProfileCommand(resource.firstName(), resource.lastName(), resource.street(),
                resource.city(), resource.country(), resource.email(), resource.username(), resource.password());
    }
}

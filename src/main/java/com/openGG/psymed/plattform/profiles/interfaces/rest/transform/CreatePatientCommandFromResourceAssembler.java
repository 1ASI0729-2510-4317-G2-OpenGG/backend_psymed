package com.openGG.psymed.plattform.profiles.interfaces.rest.transform;
import com.openGG.psymed.plattform.profiles.domain.model.commands.CreatePatientCommand;
import com.openGG.psymed.plattform.profiles.interfaces.rest.resorces.CreatePatientResource;
public class CreatePatientCommandFromResourceAssembler {


    public static CreatePatientCommand toCommandFromResource(CreatePatientResource resource) {

        return new CreatePatientCommand(
            resource.name(),
            resource.lastName(),
            resource.email()
        );
    }
}

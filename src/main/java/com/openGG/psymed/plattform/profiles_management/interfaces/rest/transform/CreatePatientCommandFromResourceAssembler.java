package com.openGG.psymed.plattform.profiles_management.interfaces.rest.transform;
import com.openGG.psymed.plattform.profiles_management.domain.model.commands.CreatePatientCommand;
import com.openGG.psymed.plattform.profiles_management.interfaces.rest.resorces.CreatePatientResource;
public class CreatePatientCommandFromResourceAssembler {


    public static CreatePatientCommand toCommandFromResource(CreatePatientResource resource) {

        return new CreatePatientCommand(
            resource.name(),
            resource.lastName(),
            resource.email()
        );
    }
}

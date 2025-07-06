package com.openGG.psymed.plattform.profiles.interfaces.rest.transform;
import com.openGG.psymed.plattform.profiles.domain.model.commands.CreateMedicCommand;
import com.openGG.psymed.plattform.profiles.interfaces.rest.resorces.CreateMedicResource;

public class CreateMedicCommandFromResourceAssembler {


    public static CreateMedicCommand toCommandFromResource(CreateMedicResource resource) {

        return new CreateMedicCommand(
                resource.name(),
                resource.lastName(),
                resource.email()
        );
    }
}

package com.openGG.psymed.plattform.Patient.clinicalhistory.interfaces.rest.transform;

import com.openGG.psymed.plattform.Patient.clinicalhistory.domain.model.commands.CreateClinicalHistoryCommand;
import com.openGG.psymed.plattform.Patient.clinicalhistory.interfaces.rest.resources.CreateClinicalHistoryResource;

public class CreateClinicalHistoryCommandFromResourceAssembler {
    public static CreateClinicalHistoryCommand toCommandFromResource(CreateClinicalHistoryResource resource) {
        return new CreateClinicalHistoryCommand(
                resource.background(),
                resource.consultationReason(),
                resource.consultationDate()
        );
    }
}

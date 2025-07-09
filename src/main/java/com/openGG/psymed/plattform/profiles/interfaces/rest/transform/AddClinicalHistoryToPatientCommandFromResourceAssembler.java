package com.openGG.psymed.plattform.profiles.interfaces.rest.transform;

import com.openGG.psymed.plattform.profiles.domain.model.commands.AddClinicalHistoryToPatientCommand;
import com.openGG.psymed.plattform.profiles.interfaces.rest.resources.AddClinicalHistoryToPatientResource;

public class AddClinicalHistoryToPatientCommandFromResourceAssembler {
    public static AddClinicalHistoryToPatientCommand toCommandFromResource(Long patientId, AddClinicalHistoryToPatientResource resource) {
        return new AddClinicalHistoryToPatientCommand(patientId, resource.background(), resource.consultationReason(), resource.consultationDate());
    }
}

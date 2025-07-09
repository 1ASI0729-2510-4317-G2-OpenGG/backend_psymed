package com.openGG.psymed.plattform.Patient_Management.patientreport.interfaces.rest.transform;

import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.commands.CreateMoodStateRecordCommand;
import com.openGG.psymed.plattform.Patient_Management.patientreport.interfaces.rest.resources.CreateMoodStateRecordResource;

public class CreateMoodStateRecordCommandFromResourceAssembler {
    public static CreateMoodStateRecordCommand toCommandFromResource(CreateMoodStateRecordResource resource, Long patientId) {
        return new CreateMoodStateRecordCommand(resource.status(), patientId);
    }
}

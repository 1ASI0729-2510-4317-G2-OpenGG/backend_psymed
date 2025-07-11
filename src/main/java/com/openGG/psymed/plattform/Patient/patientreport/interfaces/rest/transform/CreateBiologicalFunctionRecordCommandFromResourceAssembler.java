package com.openGG.psymed.plattform.Patient.patientreport.interfaces.rest.transform;

import com.openGG.psymed.plattform.Patient.patientreport.domain.model.commands.CreateBiologicalFunctionRecordCommand;
import com.openGG.psymed.plattform.Patient.patientreport.interfaces.rest.resources.CreateBiologicalFunctionRecordResource;

public class CreateBiologicalFunctionRecordCommandFromResourceAssembler {
    public static CreateBiologicalFunctionRecordCommand toCommandFromResource(CreateBiologicalFunctionRecordResource resource, Long patientId) {
        return new CreateBiologicalFunctionRecordCommand(resource.hunger(), resource.hydration(), resource.sleep(),resource.energy(), patientId);
    }
}

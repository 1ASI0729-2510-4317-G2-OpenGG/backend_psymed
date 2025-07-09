package com.openGG.psymed.plattform.Patient.patientreport.interfaces.rest.transform;

import com.openGG.psymed.plattform.Patient.patientreport.domain.model.aggregates.MoodState;
import com.openGG.psymed.plattform.Patient.patientreport.interfaces.rest.resources.MoodStateResource;

public class MoodStateResourceFromEntityAssembler {
    public static MoodStateResource toResourceFromEntity (MoodState entity) {
        return new MoodStateResource(entity.getId(), entity.getStatus());
    }
}

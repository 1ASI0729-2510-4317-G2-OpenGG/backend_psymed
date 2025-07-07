package com.openGG.psymed.plattform.profiles.interfaces.rest.transform;

import com.openGG.psymed.plattform.profiles.domain.model.aggregates.Patient;
import com.openGG.psymed.plattform.profiles.interfaces.rest.resorces.PatientResource;

public class PatientResourceFromEntityAssembler {
    public static PatientResource toResourceFromEntity(Patient entity){
        return new PatientResource(entity.getId(), entity.getName(), entity.getLastName(), entity.getDni(), entity.getEmail(), entity.getPhone(), entity.getBirthDate());
    }
}
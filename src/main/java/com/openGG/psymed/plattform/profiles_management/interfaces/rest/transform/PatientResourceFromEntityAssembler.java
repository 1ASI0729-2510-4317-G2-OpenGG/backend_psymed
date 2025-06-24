package com.openGG.psymed.plattform.profiles_management.interfaces.rest.transform;

import com.openGG.psymed.plattform.profiles_management.domain.model.aggregates.Patient;
import com.openGG.psymed.plattform.profiles_management.interfaces.rest.resorces.PatientResource;

public class PatientResourceFromEntityAssembler {
    public static PatientResource toResourceFromEntity(Patient entity){
        return new PatientResource(entity.getId(), entity.getName(), entity.getLastName(),entity.getEmail());
    }
}
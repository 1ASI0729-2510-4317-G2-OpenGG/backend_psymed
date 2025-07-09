package com.openGG.psymed.plattform.Patient.patientreport.interfaces.rest.transform;

import com.openGG.psymed.plattform.Patient.patientreport.domain.model.aggregates.BiologicalFunction;
import com.openGG.psymed.plattform.Patient.patientreport.interfaces.rest.resources.BiologicalFunctionResource;

public class BiologicalFunctionResourceFromEntityAssembler {
    public static BiologicalFunctionResource toResourceFromEntity(BiologicalFunction entity) {
        return new BiologicalFunctionResource(entity.getId(), entity.getHunger()
                , entity.getHydration(), entity.getSleep(), entity.getEnergy());
    }
}

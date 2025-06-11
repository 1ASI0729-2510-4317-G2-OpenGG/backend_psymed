package com.openGG.psymed.plattform.medication_management.interfaces.rest.transform;

import com.openGG.psymed.plattform.medication_management.domain.model.aggregates.Pills;
import com.openGG.psymed.plattform.medication_management.interfaces.rest.resorces.PillResource;

public class PillResourceFromEntityAssembler {
    public static PillResource toResourceFromEntity(Pills entity){
        return new PillResource(entity.getId(), entity.getName(), entity.getDescription(),entity.getPatientId(), entity.getInterval(), entity.getQuantity());
    }
}
package com.openGG.psymed.plattform.Medical_Management.Medicaments.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medical_Management.Medicaments.domain.model.aggregates.Pills;
import com.openGG.psymed.plattform.Medical_Management.Medicaments.interfaces.rest.resorces.PillResource;

public class PillResourceFromEntityAssembler {
    public static PillResource toResourceFromEntity(Pills entity){
        return new PillResource(entity.getId(), entity.getName(), entity.getDescription(),entity.getPatientId(), entity.getInterval(), entity.getQuantity());
    }
}
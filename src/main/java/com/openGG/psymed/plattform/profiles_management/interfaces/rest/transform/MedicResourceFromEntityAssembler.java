package com.openGG.psymed.plattform.profiles_management.interfaces.rest.transform;
import com.openGG.psymed.plattform.profiles_management.domain.model.aggregates.Medic;
import com.openGG.psymed.plattform.profiles_management.interfaces.rest.resorces.MedicResource;

public class MedicResourceFromEntityAssembler {
    public static MedicResource toResourceFromEntity(Medic entity){
        return new MedicResource(entity.getId(), entity.getName(), entity.getLastName(),entity.getEmail());
    }
}
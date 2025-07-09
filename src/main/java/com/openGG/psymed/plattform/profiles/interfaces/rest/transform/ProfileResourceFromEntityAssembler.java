package com.openGG.psymed.plattform.profiles.interfaces.rest.transform;

import com.openGG.psymed.plattform.profiles.domain.model.aggregates.PatientProfile;
import com.openGG.psymed.plattform.profiles.domain.model.aggregates.ProfessionalProfile;
import com.openGG.psymed.plattform.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(PatientProfile entity) {
        return new ProfileResource(entity.getId(), entity.getFullName(), entity.getEmail(), entity.getStreetAddress(),entity.getAccountId(), entity.getProfessionalId());
    }


    public static ProfileResource toResourceFromEntity(ProfessionalProfile entity){
        return new ProfileResource(entity.getId(), entity.getFullName(), entity.getEmail(), entity.getStreetAddress(), entity.getAccountId(), entity.getId());
    }
}


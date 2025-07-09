package com.openGG.psymed.plattform.profiles.domain.services;


import com.openGG.psymed.plattform.profiles.domain.model.aggregates.ProfessionalProfile;
import com.openGG.psymed.plattform.profiles.domain.model.queries.GetProfessionalProfileByAccountIdQuery;
import com.openGG.psymed.plattform.profiles.domain.model.queries.GetProfessionalProfileByIdQuery;

import java.util.Optional;

public interface ProfessionalProfileQueryService {
    Optional<ProfessionalProfile> handle(GetProfessionalProfileByIdQuery query);

    Optional<ProfessionalProfile> handle(GetProfessionalProfileByAccountIdQuery query);

}

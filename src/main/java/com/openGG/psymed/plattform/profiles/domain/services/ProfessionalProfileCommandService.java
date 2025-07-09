package com.openGG.psymed.plattform.profiles.domain.services;


import com.openGG.psymed.plattform.profiles.domain.model.aggregates.ProfessionalProfile;
import com.openGG.psymed.plattform.profiles.domain.model.commands.CheckProfessionalProfileByIdCommand;
import com.openGG.psymed.plattform.profiles.domain.model.commands.CreateProfessionalProfileCommand;

import java.util.Optional;

public interface ProfessionalProfileCommandService {
    Optional<ProfessionalProfile> handle(CreateProfessionalProfileCommand command);
    boolean handle(CheckProfessionalProfileByIdCommand command);
}

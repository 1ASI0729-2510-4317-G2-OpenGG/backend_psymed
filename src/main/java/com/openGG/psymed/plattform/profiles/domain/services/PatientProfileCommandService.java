package com.openGG.psymed.plattform.profiles.domain.services;


import com.openGG.psymed.plattform.profiles.domain.model.aggregates.PatientProfile;
import com.openGG.psymed.plattform.profiles.domain.model.commands.AddClinicalHistoryToPatientCommand;
import com.openGG.psymed.plattform.profiles.domain.model.commands.CheckPatientProfileByIdCommand;
import com.openGG.psymed.plattform.profiles.domain.model.commands.CreatePatientProfileCommand;

import java.util.Optional;

public interface PatientProfileCommandService {
    Optional<PatientProfile> handle(CreatePatientProfileCommand command);
    boolean handle(CheckPatientProfileByIdCommand command);
    void handle(AddClinicalHistoryToPatientCommand command);
}

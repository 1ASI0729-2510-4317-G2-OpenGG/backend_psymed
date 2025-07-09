package com.openGG.psymed.plattform.Patient.patientreport.domain.services;


import com.openGG.psymed.plattform.Patient.patientreport.domain.model.aggregates.MoodState;
import com.openGG.psymed.plattform.Patient.patientreport.domain.model.commands.CreateMoodStateRecordCommand;

import java.util.Optional;

public interface MoodStateCommandService {
    Optional<MoodState> handle(CreateMoodStateRecordCommand command);

}

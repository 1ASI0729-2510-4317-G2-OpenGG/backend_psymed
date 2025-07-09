package com.openGG.psymed.plattform.Patient_Management.patientreport.domain.services;


import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.aggregates.MoodState;
import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.commands.CreateMoodStateRecordCommand;

import java.util.Optional;

public interface MoodStateCommandService {
    Optional<MoodState> handle(CreateMoodStateRecordCommand command);

}

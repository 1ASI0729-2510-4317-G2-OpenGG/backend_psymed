package com.openGG.psymed.plattform.Patient_Management.clinicalhistory.domain.service;

import com.openGG.psymed.plattform.Patient_Management.clinicalhistory.domain.model.aggregates.ClinicalHistory;
import com.openGG.psymed.plattform.Patient_Management.clinicalhistory.domain.model.commands.CreateClinicalHistoryCommand;

import java.util.Optional;

public interface ClinicalHistoryCommandService {
    Optional<ClinicalHistory> handle(CreateClinicalHistoryCommand command);
}

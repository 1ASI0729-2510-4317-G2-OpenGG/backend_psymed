package com.openGG.psymed.plattform.Patient.clinicalhistory.domain.service;

import com.openGG.psymed.plattform.Patient.clinicalhistory.domain.model.aggregates.ClinicalHistory;
import com.openGG.psymed.plattform.Patient.clinicalhistory.domain.model.commands.CreateClinicalHistoryCommand;

import java.util.Optional;

public interface ClinicalHistoryCommandService {
    Optional<ClinicalHistory> handle(CreateClinicalHistoryCommand command);
}

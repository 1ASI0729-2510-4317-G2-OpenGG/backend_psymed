package com.openGG.psymed.plattform.Patient.clinicalhistory.domain.service;

import com.openGG.psymed.plattform.Patient.clinicalhistory.domain.model.aggregates.ClinicalHistory;
import com.openGG.psymed.plattform.Patient.clinicalhistory.domain.model.queries.GetClinicalHistoryByIdQuery;
import com.openGG.psymed.plattform.Patient.clinicalhistory.domain.model.queries.GetClinicalHistoryByPatientIdQuery;

import java.util.Optional;

public interface ClinicalHistoryQueryService {
    Optional<ClinicalHistory> handle(GetClinicalHistoryByIdQuery query);
    Optional<ClinicalHistory> handle(GetClinicalHistoryByPatientIdQuery query);
}

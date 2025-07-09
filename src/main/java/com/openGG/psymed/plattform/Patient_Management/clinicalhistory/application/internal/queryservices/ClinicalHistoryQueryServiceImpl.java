package com.openGG.psymed.plattform.Patient_Management.clinicalhistory.application.internal.queryservices;

import com.openGG.psymed.plattform.Patient_Management.clinicalhistory.application.internal.outboundservices.CExternalProfileService;
import com.openGG.psymed.plattform.Patient_Management.clinicalhistory.domain.model.aggregates.ClinicalHistory;
import com.openGG.psymed.plattform.Patient_Management.clinicalhistory.domain.model.queries.GetClinicalHistoryByIdQuery;
import com.openGG.psymed.plattform.Patient_Management.clinicalhistory.domain.model.queries.GetClinicalHistoryByPatientIdQuery;
import com.openGG.psymed.plattform.Patient_Management.clinicalhistory.domain.service.ClinicalHistoryQueryService;
import com.openGG.psymed.plattform.Patient_Management.clinicalhistory.infrastructure.persistence.jpa.repositories.ClinicalHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinicalHistoryQueryServiceImpl implements ClinicalHistoryQueryService {
    private final ClinicalHistoryRepository clinicalHistoryRepository;
    private final CExternalProfileService externalProfileService;
    public ClinicalHistoryQueryServiceImpl(ClinicalHistoryRepository clinicalHistoryRepository, CExternalProfileService externalProfileService) {
        this.clinicalHistoryRepository = clinicalHistoryRepository;
        this.externalProfileService = externalProfileService;
    }
    @Override
    public Optional<ClinicalHistory> handle(GetClinicalHistoryByIdQuery query) {
        return this.clinicalHistoryRepository.findById(query.clinicalHistoryId());
    }
    @Override
    public Optional<ClinicalHistory> handle(GetClinicalHistoryByPatientIdQuery query) {
        var clinicalHistoryId = externalProfileService.getClinicalHistoryIdByPatientId(query.patientId());
        return this.clinicalHistoryRepository.findById(clinicalHistoryId);
    }
}

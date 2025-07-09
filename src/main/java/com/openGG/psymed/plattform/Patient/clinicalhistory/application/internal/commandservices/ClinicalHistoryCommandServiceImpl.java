package com.openGG.psymed.plattform.Patient.clinicalhistory.application.internal.commandservices;

import com.openGG.psymed.plattform.Patient.clinicalhistory.domain.model.aggregates.ClinicalHistory;
import com.openGG.psymed.plattform.Patient.clinicalhistory.domain.model.commands.CreateClinicalHistoryCommand;
import com.openGG.psymed.plattform.Patient.clinicalhistory.domain.service.ClinicalHistoryCommandService;
import com.openGG.psymed.plattform.Patient.clinicalhistory.infrastructure.persistence.jpa.repositories.ClinicalHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinicalHistoryCommandServiceImpl implements ClinicalHistoryCommandService {

    private final ClinicalHistoryRepository clinicalHistoryRepository;

    public ClinicalHistoryCommandServiceImpl(ClinicalHistoryRepository clinicalHistoryRepository) {
        this.clinicalHistoryRepository = clinicalHistoryRepository;
    }

    @Override
    public Optional<ClinicalHistory> handle(CreateClinicalHistoryCommand command) {

        ClinicalHistory clinicalHistory = new ClinicalHistory(command);

        try{
            var createdClinicalHistory = this.clinicalHistoryRepository.save(clinicalHistory);
            return Optional.of(createdClinicalHistory);
        }catch(Exception e){
            throw new IllegalArgumentException("Error creating the clinical history record: %s"
                    .formatted(e.getMessage()));
        }
    }
}

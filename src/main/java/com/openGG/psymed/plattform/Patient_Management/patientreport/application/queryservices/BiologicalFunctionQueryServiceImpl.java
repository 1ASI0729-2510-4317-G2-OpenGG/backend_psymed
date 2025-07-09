package com.openGG.psymed.plattform.Patient_Management.patientreport.application.queryservices;

import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.aggregates.BiologicalFunction;
import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.queries.GetAllBiologicalFunctionsByPatientIdQuery;
import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.services.BiologicalFunctionQueryService;
import com.openGG.psymed.plattform.Patient_Management.patientreport.infrastructure.persistence.jpa.repositories.BiologicalFunctionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiologicalFunctionQueryServiceImpl implements BiologicalFunctionQueryService {
    private final BiologicalFunctionRepository biologicalFunctionRepository;

    public BiologicalFunctionQueryServiceImpl(BiologicalFunctionRepository biologicalFunctionRepository) {
        this.biologicalFunctionRepository = biologicalFunctionRepository;
    }

    @Override
    public List<BiologicalFunction> handle(GetAllBiologicalFunctionsByPatientIdQuery query) {
        return biologicalFunctionRepository.findAllByPatientId(query.patientId());
    }

}

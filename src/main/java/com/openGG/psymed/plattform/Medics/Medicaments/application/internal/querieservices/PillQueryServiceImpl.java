package com.openGG.psymed.plattform.Medics.Medicaments.application.internal.querieservices;

import com.openGG.psymed.plattform.Medics.Medicaments.domain.model.aggregates.Pills;
import com.openGG.psymed.plattform.Medics.Medicaments.domain.model.queries.GetAllPillsQuery;
import com.openGG.psymed.plattform.Medics.Medicaments.domain.model.queries.GetPillByNameQuery;
import com.openGG.psymed.plattform.Medics.Medicaments.domain.model.queries.GetPillsByIdQuery;
import com.openGG.psymed.plattform.Medics.Medicaments.domain.model.queries.GetPillsByPatientId;
import com.openGG.psymed.plattform.Medics.Medicaments.domain.service.PillQueryService;
import com.openGG.psymed.plattform.Medics.Medicaments.infrastructure.persistence.jpa.repositories.PillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PillQueryServiceImpl implements PillQueryService {
    private final PillRepository pillRepository;

    public PillQueryServiceImpl(PillRepository pillRepository) {
        this.pillRepository = pillRepository;
    }

    @Override
    public Optional<Pills> handle(GetPillByNameQuery query) {
        return Optional.empty();
    }

    @Override
    public List<Pills> handle(GetAllPillsQuery query) {

        return pillRepository.findAll();
    }

    @Override
    public Optional<Pills> handle(GetPillsByIdQuery getPillsByIdQuery) {

        return pillRepository.findById(getPillsByIdQuery.medicationId());
    }

    @Override
    public List<Pills> handle(GetPillsByPatientId getPillsByPatientId) {

        return pillRepository.findByPatientId(getPillsByPatientId.patientId());
    }

}

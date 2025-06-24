package com.openGG.psymed.plattform.profiles_management.application.internal.querieservices;

import com.openGG.psymed.plattform.profiles_management.domain.model.aggregates.Medic;
import com.openGG.psymed.plattform.profiles_management.domain.model.queries.*;
import com.openGG.psymed.plattform.profiles_management.domain.service.MedicQueryService;
import com.openGG.psymed.plattform.profiles_management.infratructure.persistence.jpa.repositories.MedicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicQueryServiceImpl implements MedicQueryService {
    private final MedicRepository medicRepository;

    public MedicQueryServiceImpl(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    @Override
    public List<Medic> handle(GetAllMedicsQuery query) {
        return medicRepository.findAll();
    }

    @Override
    public Optional<Medic> handle(GetMedicByIdQuery query) {
        return medicRepository.findById(query.medicId());
    }

    @Override
    public Optional<Medic> handle(GetMedicByEmailQuery query) {
        return medicRepository.findByEmail(query.email());
    }

    @Override
    public Optional<Medic> handle(GetMedicByNameQuery query) {
        return medicRepository.findByName(query.name());
    }

    @Override
    public Optional<Medic> handle(GetMedicByLastNameQuery query) {
        return medicRepository.findByLastName(query.lastName());
    }
}

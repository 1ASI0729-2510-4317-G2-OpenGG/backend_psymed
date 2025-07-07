package com.openGG.psymed.plattform.profiles.application.internal.querieservices;

import com.openGG.psymed.plattform.profiles.domain.model.aggregates.Patient;
import com.openGG.psymed.plattform.profiles.domain.model.queries.*;
import com.openGG.psymed.plattform.profiles.domain.service.PatientQueryService;
import com.openGG.psymed.plattform.profiles.infratructure.persistence.jpa.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientQueryServiceImpl implements PatientQueryService {
    private final PatientRepository patientRepository;

    public PatientQueryServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> handle(GetAllPatientsQuery query) {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> handle(GetPatientByIdQuery query) {
        return patientRepository.findById(query.patientId());
    }

    @Override
    public Optional<Patient> handle(GetPatientByEmailQuery query) {
        return patientRepository.findByEmail(query.email());
    }

    @Override
    public Optional<Patient> handle(GetPatientByNameQuery query) {
        return patientRepository.findByName(query.name());
    }

    @Override
    public Optional<Patient> handle(GetPatientByLastNameQuery query) {
        return patientRepository.findByLastName(query.lastName());
    }
}

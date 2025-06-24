package com.openGG.psymed.plattform.profiles_management.domain.service;

import com.openGG.psymed.plattform.profiles_management.domain.model.aggregates.Patient;
import com.openGG.psymed.plattform.profiles_management.domain.model.queries.*;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface PatientQueryService {

    List<Patient> handle(GetAllPatientsQuery query);

    Optional<Patient> handle(GetPatientByIdQuery query);

    Optional<Patient> handle(GetPatientByEmailQuery query);

    Optional<Patient> handle(GetPatientByNameQuery query);

    Optional<Patient> handle(GetPatientByLastNameQuery query);
}

package com.openGG.psymed.plattform.Patient_Management.patientreport.infrastructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.aggregates.BiologicalFunction;
import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.valueobjects.PatientId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BiologicalFunctionRepository extends JpaRepository<BiologicalFunction, Long> {
    List<BiologicalFunction> findAllByPatientId(PatientId patientId);
    boolean existsByPatientId(PatientId patientId);
}

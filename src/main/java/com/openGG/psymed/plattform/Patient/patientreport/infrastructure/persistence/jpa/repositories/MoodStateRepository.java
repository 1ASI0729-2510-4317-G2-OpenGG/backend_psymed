package com.openGG.psymed.plattform.Patient.patientreport.infrastructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.Patient.patientreport.domain.model.aggregates.MoodState;
import com.openGG.psymed.plattform.Patient.patientreport.domain.model.valueobjects.PatientId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoodStateRepository extends JpaRepository<MoodState, Long> {
    List<MoodState> findAllByPatientId(PatientId patientId);
    boolean existsByPatientId(PatientId patientId);
}

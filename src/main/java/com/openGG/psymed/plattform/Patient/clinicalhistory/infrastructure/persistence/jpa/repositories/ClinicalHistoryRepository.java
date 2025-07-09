package com.openGG.psymed.plattform.Patient.clinicalhistory.infrastructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.Patient.clinicalhistory.domain.model.aggregates.ClinicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalHistoryRepository extends JpaRepository<ClinicalHistory,Long> {

}

package com.openGG.psymed.plattform.Patient_Management.clinicalhistory.infrastructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.Patient_Management.clinicalhistory.domain.model.aggregates.ClinicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalHistoryRepository extends JpaRepository<ClinicalHistory,Long> {

}

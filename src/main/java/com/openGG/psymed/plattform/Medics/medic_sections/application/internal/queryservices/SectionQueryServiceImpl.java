package com.openGG.psymed.plattform.Medics.medic_sections.application.internal.queryservices;

import com.openGG.psymed.plattform.Medics.medic_sections.domain.model.queries.GetSectionsByPatientIdQuery;
import com.openGG.psymed.plattform.Medics.medic_sections.domain.model.entities.Section;
import com.openGG.psymed.plattform.Medics.medic_sections.infrastructure.persistence.jpa.repositories.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Query service implementation for retrieving medical sections.
 * Handles queries related to fetching {@link Section} entities by patient ID.
 */

@Service
public class SectionQueryServiceImpl {

    private final SectionRepository sectionRepository;

    /**
     * Constructs a new {@code SectionQueryServiceImpl} with the given repository.
     *
     * @param sectionRepository the repository used to retrieve section data
     */

    public SectionQueryServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    /**
     * Handles the query to retrieve all sections for a specific patient.
     *
     * @param query the query object containing the patient ID
     * @return a list of {@link Section} entities associated with the given patient
     */

    public List<Section> handle(GetSectionsByPatientIdQuery query) {
        return sectionRepository.findByPatientId(query.patientId());
    }
}
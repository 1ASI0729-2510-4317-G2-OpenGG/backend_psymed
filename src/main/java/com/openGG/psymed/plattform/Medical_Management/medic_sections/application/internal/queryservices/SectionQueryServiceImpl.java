package com.openGG.psymed.plattform.Medical_Management.medic_sections.application.internal.queryservices;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.queries.GetSectionsByPatientIdQuery;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.entities.Section;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.infrastructure.persistence.jpa.repositories.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionQueryServiceImpl {

    private final SectionRepository sectionRepository;

    public SectionQueryServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public List<Section> handle(GetSectionsByPatientIdQuery query) {
        return sectionRepository.findByPatientId(query.patientId());
    }
}
package com.openGG.psymed.plattform.Medics.medic_sections.interfaces.rest;

import com.openGG.psymed.plattform.Medics.medic_sections.application.internal.commandservices.SectionCommandServiceImpl;
import com.openGG.psymed.plattform.Medics.medic_sections.application.internal.queryservices.SectionQueryServiceImpl;
import com.openGG.psymed.plattform.Medics.medic_sections.domain.model.queries.GetSectionsByPatientIdQuery;
import com.openGG.psymed.plattform.Medics.medic_sections.interfaces.rest.resources.CreateSectionResource;
import com.openGG.psymed.plattform.Medics.medic_sections.interfaces.rest.resources.SectionResource;
import com.openGG.psymed.plattform.Medics.medic_sections.interfaces.rest.transform.CreateSectionCommandFromResourceAssembler;
import com.openGG.psymed.plattform.Medics.medic_sections.interfaces.rest.transform.SectionResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing medical sections.
 * Provides endpoints for creating and retrieving patient-related medical section records
 * such as diagnoses, therapy notes, or observations.
 */

@RestController
@RequestMapping("/api/sections")
@Tag(name="medical-section", description = "Medical register about diagnosis, therapy, notes")
public class SectionController {

    private final SectionCommandServiceImpl commandService;
    private final SectionQueryServiceImpl queryService;

    /**
     * Constructs a new {@code SectionController} with the provided services.
     *
     * @param commandService the service responsible for handling section creation
     * @param queryService   the service responsible for retrieving sections
     */

    public SectionController(SectionCommandServiceImpl commandService,
                             SectionQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    /**
     * Creates a new medical section for a patient.
     *
     * @param resource the resource object containing the section data
     * @return the created {@link SectionResource}
     */

    @PostMapping
    @Operation(summary = "Create new medical section")
    public SectionResource create(@RequestBody CreateSectionResource resource) {
        var command = CreateSectionCommandFromResourceAssembler.toCommandFromResource(resource);
        var section = commandService.handle(command);
        return SectionResourceFromEntityAssembler.toResourceFromEntity(section);
    }


    /**
     * Retrieves all medical sections associated with a specific patient.
     *
     * @param patientId the ID of the patient
     * @return a list of {@link SectionResource} belonging to the given patient
     */

    @GetMapping("/patient/{patientId}")
    public List<SectionResource> getByPatient(@PathVariable Long patientId) {
        return queryService.handle(new GetSectionsByPatientIdQuery(patientId))
                .stream()
                .map(SectionResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
    }
}

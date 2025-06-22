package com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.application.internal.commandservices.SectionCommandServiceImpl;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.application.internal.queryservices.SectionQueryServiceImpl;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.queries.GetSectionsByPatientIdQuery;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.resources.CreateSectionResource;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.resources.SectionResource;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.transform.CreateSectionCommandFromResourceAssembler;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.transform.SectionResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
@Tag(name="medical-section", description = "Medical register about diagnosis, therapy, notes")
public class SectionController {

    private final SectionCommandServiceImpl commandService;
    private final SectionQueryServiceImpl queryService;

    public SectionController(SectionCommandServiceImpl commandService,
                             SectionQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    @Operation(summary = "Create new medical section")
    public SectionResource create(@RequestBody CreateSectionResource resource) {
        var command = CreateSectionCommandFromResourceAssembler.toCommandFromResource(resource);
        var section = commandService.handle(command);
        return SectionResourceFromEntityAssembler.toResourceFromEntity(section);
    }

    @GetMapping("/patient/{patientId}")
    public List<SectionResource> getByPatient(@PathVariable Long patientId) {
        return queryService.handle(new GetSectionsByPatientIdQuery(patientId))
                .stream()
                .map(SectionResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
    }
}

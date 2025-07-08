package com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.services.SectionCommandService;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.resources.CreateSectionResource;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.resources.SectionResource;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.transform.CreateSectionCommandFromResourceAssembler;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.transform.SectionResourceFromEntityAssembler;
import com.openGG.psymed.plattform.Medical_Management.medic_sections.infrastructure.acl.external.profiles.ProfileContextFacade;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing medical diagnosis sections for patients.
 * This controller allows authorized medical users to create and delete their own sections.
 */

@RestController
@RequestMapping("/api/v1/sections")
@Tag(name = "medical-diagnoses", description = "Managing a patient's diagnoses")
public class SectionController {

    private final SectionCommandService commandService;
    private final CreateSectionCommandFromResourceAssembler commandAssembler;
    private final SectionResourceFromEntityAssembler sectionAssembler;
    private final ProfileContextFacade profileContextFacade;

    /**
     * Constructor for injecting required services and assemblers.
     *
     * @param commandService         the service to handle commands related to sections
     * @param commandAssembler       assembler to convert request resources into command objects
     * @param sectionAssembler       assembler to convert domain entities into REST resources
     * @param profileContextFacade   ACL to resolve medic identity from an email address
     */

    public SectionController(
            SectionCommandService commandService,
            CreateSectionCommandFromResourceAssembler commandAssembler,
            SectionResourceFromEntityAssembler sectionAssembler,
            ProfileContextFacade profileContextFacade
    ) {
        this.commandService = commandService;
        this.commandAssembler = commandAssembler;
        this.sectionAssembler = sectionAssembler;
        this.profileContextFacade = profileContextFacade;
    }

    /**
     * Creates a new medical section for a given patient, based on the authenticated medic.
     *
     * @param medicEmail the email address of the authenticated medic (provided in the request header)
     * @param resource   the request body containing the new section's data
     * @return a {@link ResponseEntity} with the created {@link SectionResource}
     */

    @PostMapping
    public ResponseEntity<SectionResource> create(
            @RequestHeader("X-User-Email") String medicEmail,
            @RequestBody CreateSectionResource resource
    ) {
        Long medicId = profileContextFacade.getMedicIdByEmail(medicEmail);
        var command = commandAssembler.toCommand(resource, medicId);
        var section = commandService.create(command);
        var response = sectionAssembler.toResource(section);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Deletes a section if the authenticated medic is the owner of that section.
     *
     * @param sectionId  the ID of the section to delete
     * @param medicEmail the email of the medic making the request (used for ACL validation)
     * @return an empty {@link ResponseEntity} with HTTP 204 No Content
     */

    @DeleteMapping("/{sectionId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long sectionId,
            @RequestHeader("X-User-Email") String medicEmail
    ) {
        Long medicId = profileContextFacade.getMedicIdByEmail(medicEmail);
        commandService.deleteIfOwner(sectionId, medicId);
        return ResponseEntity.noContent().build();
    }
}
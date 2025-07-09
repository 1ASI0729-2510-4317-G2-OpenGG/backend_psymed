package com.openGG.psymed.plattform.profiles.interfaces.rest;

import com.openGG.psymed.plattform.profiles.domain.model.queries.GetAllPatientProfilesQuery;
import com.openGG.psymed.plattform.profiles.domain.model.queries.GetPatientProfileByAccountIdQuery;
import com.openGG.psymed.plattform.profiles.domain.model.queries.GetPatientProfileByIdQuery;
import com.openGG.psymed.plattform.profiles.domain.model.queries.GetPatientProfileByProfessionalIdQuery;
import com.openGG.psymed.plattform.profiles.domain.model.valueobjects.AccountId;
import com.openGG.psymed.plattform.profiles.domain.services.PatientProfileCommandService;
import com.openGG.psymed.plattform.profiles.domain.services.PatientProfileQueryService;
import com.openGG.psymed.plattform.profiles.interfaces.rest.resources.CreatePatientProfileResource;
import com.openGG.psymed.plattform.profiles.interfaces.rest.resources.ProfileResource;
import com.openGG.psymed.plattform.profiles.interfaces.rest.transform.CreatePatientProfileCommandFromResourceAssembler;
import com.openGG.psymed.plattform.profiles.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/patient-profiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Patient Profile", description = "Patient Profiles Management Endpoints ")
public class PatientProfileController {
    private final PatientProfileCommandService patientProfileCommandService;
    private final PatientProfileQueryService patientProfileQueryService;

    public PatientProfileController(PatientProfileCommandService patientProfileCommandService, PatientProfileQueryService patientProfileQueryService) {
        this.patientProfileCommandService = patientProfileCommandService;
        this.patientProfileQueryService = patientProfileQueryService;
    }

    @PostMapping
    public ResponseEntity<ProfileResource> createProfile(@RequestBody CreatePatientProfileResource resource) {
        var createPatientProfileCommand = CreatePatientProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        var profile = patientProfileCommandService.handle(createPatientProfileCommand);

        if(profile.isEmpty()) return ResponseEntity.badRequest().build();

        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable Long profileId) {
        var getProfileByIdQuery = new GetPatientProfileByIdQuery(profileId);
        var profile = patientProfileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) return ResponseEntity.notFound().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<ProfileResource> getProfileByAccountId(@PathVariable Long accountId) {
        var getPatientProfileByIdQuery = new GetPatientProfileByAccountIdQuery(new AccountId(accountId));
        var profile = patientProfileQueryService.handle(getPatientProfileByIdQuery);
        if (profile.isEmpty()) return ResponseEntity.notFound().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }

    @GetMapping("/professional/{professionalId}")
    public ResponseEntity<List<ProfileResource>> getProfilesByProfessionalId(@PathVariable Long professionalId) {
        var getPatientProfileByProfessionalIdQuery = new GetPatientProfileByProfessionalIdQuery(professionalId);
        var profiles = patientProfileQueryService.handle(getPatientProfileByProfessionalIdQuery);
        if (profiles.isEmpty()) return ResponseEntity.notFound().build();
        var profileResources = profiles.stream()
                .map(ProfileResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(profileResources);
    }

    @GetMapping
    public ResponseEntity<List<ProfileResource>> getAllProfiles() {
        var getAllProfilesQuery = new GetAllPatientProfilesQuery();
        var profiles = patientProfileQueryService.handle(getAllProfilesQuery);
        var profileResources = profiles.stream().map(ProfileResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(profileResources);
    }
}

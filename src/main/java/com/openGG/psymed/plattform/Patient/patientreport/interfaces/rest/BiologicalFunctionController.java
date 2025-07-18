package com.openGG.psymed.plattform.Patient.patientreport.interfaces.rest;

import com.openGG.psymed.plattform.Patient.patientreport.domain.model.aggregates.BiologicalFunction;
import com.openGG.psymed.plattform.Patient.patientreport.domain.model.queries.GetAllBiologicalFunctionsByPatientIdQuery;
import com.openGG.psymed.plattform.Patient.patientreport.domain.model.valueobjects.PatientId;
import com.openGG.psymed.plattform.Patient.patientreport.domain.services.BiologicalFunctionCommandService;
import com.openGG.psymed.plattform.Patient.patientreport.domain.services.BiologicalFunctionQueryService;
import com.openGG.psymed.plattform.Patient.patientreport.interfaces.rest.resources.BiologicalFunctionResource;
import com.openGG.psymed.plattform.Patient.patientreport.interfaces.rest.resources.CreateBiologicalFunctionRecordResource;
import com.openGG.psymed.plattform.Patient.patientreport.interfaces.rest.transform.BiologicalFunctionResourceFromEntityAssembler;
import com.openGG.psymed.plattform.Patient.patientreport.interfaces.rest.transform.CreateBiologicalFunctionRecordCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Patient Reports", description = "Controllers for managing patient reports")
public class BiologicalFunctionController {
    private final BiologicalFunctionCommandService biologicalFunctionCommandService;
    private final BiologicalFunctionQueryService biologicalFunctionQueryService;

    public BiologicalFunctionController(BiologicalFunctionCommandService biologicalFunctionCommandService,
                                        BiologicalFunctionQueryService biologicalFunctionQueryService){
        this.biologicalFunctionCommandService = biologicalFunctionCommandService;
        this.biologicalFunctionQueryService = biologicalFunctionQueryService;
    }

    @PostMapping("/patients/{patientId}/biological-functions")
    public ResponseEntity<BiologicalFunctionResource> createBiologicalFunction
            (@PathVariable Long patientId,  @RequestBody CreateBiologicalFunctionRecordResource resource) {
        Optional<BiologicalFunction> biologicalFunction = biologicalFunctionCommandService
                .handle(CreateBiologicalFunctionRecordCommandFromResourceAssembler.toCommandFromResource(resource, patientId));
        return biologicalFunction.map(biological ->
                new ResponseEntity<>(BiologicalFunctionResourceFromEntityAssembler
                        .toResourceFromEntity(biological), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }
//IN THE FUTURE THIS HAS TO WORK WITH PATIENT ID AND PROFESSIONAL ID
    @GetMapping("/patients/{patientId}/biological-functions")
    public ResponseEntity<List<BiologicalFunctionResource>> getAllBiologicalFunctionsByPatientId(@PathVariable Long patientId) {
        var patientIdConstructed = new PatientId(patientId);
        var getAllBiologicalFunctionsByPatientIdQuery = new GetAllBiologicalFunctionsByPatientIdQuery(patientIdConstructed);
        var biologicalFunctions = biologicalFunctionQueryService.handle(getAllBiologicalFunctionsByPatientIdQuery);
        var biologicalFunctionsResources = biologicalFunctions.stream()
                .map(BiologicalFunctionResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(biologicalFunctionsResources);
    }

}

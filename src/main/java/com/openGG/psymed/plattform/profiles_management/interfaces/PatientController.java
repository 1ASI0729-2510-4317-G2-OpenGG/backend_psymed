package com.openGG.psymed.plattform.profiles_management.interfaces;

import com.openGG.psymed.plattform.profiles_management.domain.model.commands.DeletePatientCommand;
import com.openGG.psymed.plattform.profiles_management.domain.model.commands.UpdatePatientCommand;
import com.openGG.psymed.plattform.profiles_management.domain.model.queries.*;
import com.openGG.psymed.plattform.profiles_management.domain.service.PatientCommandService;
import com.openGG.psymed.plattform.profiles_management.domain.service.PatientQueryService;
import com.openGG.psymed.plattform.profiles_management.interfaces.rest.resorces.CreatePatientResource;
import com.openGG.psymed.plattform.profiles_management.interfaces.rest.resorces.PatientResource;
import com.openGG.psymed.plattform.profiles_management.interfaces.rest.transform.CreatePatientCommandFromResourceAssembler;
import com.openGG.psymed.plattform.profiles_management.interfaces.rest.transform.PatientResourceFromEntityAssembler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Controlador para la gestión de pacientes.
 * Proporciona endpoints para crear, obtener y eliminar pacientes.
 */
@RestController
@RequestMapping(value = "/api/v1/patients", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Patient_management", description = "All patient related endpoints")
public class PatientController {

    private final PatientCommandService patientCommandService;
    private final PatientQueryService patientQueryService;

    /**
     * Constructor del controlador de pacientes.
     *
     * @param patientCommandService Servicio para ejecutar comandos relacionados con pacientes.
     * @param patientQueryService   Servicio para ejecutar consultas sobre pacientes.
     */
    public PatientController(PatientCommandService patientCommandService, PatientQueryService patientQueryService) {
        this.patientCommandService = patientCommandService;
        this.patientQueryService = patientQueryService;
    }

    /**
     * Crea un nuevo paciente.
     *
     * @param createPatientResource Recurso con los datos del paciente a crear.
     * @return ResponseEntity con el paciente creado o un estado de error.
     */
    @Operation(summary = "Create a new Patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Patient created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Patient not found")
    })
    @PostMapping
    public ResponseEntity<PatientResource> createPatient(@RequestBody CreatePatientResource createPatientResource) {
        var createPatientCommand = CreatePatientCommandFromResourceAssembler.toCommandFromResource(createPatientResource);
        var patientId = patientCommandService.handle(createPatientCommand);
        if (patientId == null || patientId == 0L) return ResponseEntity.badRequest().build();
        var getPatientByIdQuery = new GetPatientByIdQuery(patientId);
        var patient = patientQueryService.handle(getPatientByIdQuery);

        if (patient.isEmpty()) return ResponseEntity.notFound().build();
        var patientEntity = patient.get();
        var patientResource = PatientResourceFromEntityAssembler.toResourceFromEntity(patientEntity);
        return new ResponseEntity<>(patientResource, HttpStatus.CREATED);
    }

    /**
     * Obtiene todos los pacientes registrados.
     *
     * @return ResponseEntity con la lista de pacientes o un estado de error.
     */
    @Operation(summary = "Get all Patients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patients found"),
            @ApiResponse(responseCode = "404", description = "Patients not found")
    })
    @GetMapping
    public ResponseEntity<List<PatientResource>> getAllPatients() {
        var getAllPatientsQuery = new GetAllPatientsQuery();
        var patients = patientQueryService.handle(getAllPatientsQuery);
        var patientResources = patients.stream()
                .map(PatientResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(patientResources);
    }

    /**
     * Obtiene un paciente por su ID.
     *
     * @param id El ID del paciente a buscar.
     * @return ResponseEntity con el paciente encontrado o un estado de error.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PatientResource> getPatientById(@PathVariable Long id) {
        var getPatientByIdQuery = new GetPatientByIdQuery(id);
        var patient = patientQueryService.handle(getPatientByIdQuery);
        if (patient.isEmpty()) return ResponseEntity.notFound().build();
        var patientResource = PatientResourceFromEntityAssembler.toResourceFromEntity(patient.get());
        return ResponseEntity.ok(patientResource);
    }

    /**
     * Elimina un paciente por su ID.
     *
     * @param id El ID del paciente a eliminar.
     * @return ResponseEntity con un mensaje de éxito o error.
     */
    @Operation(summary = "Delete a Patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient deleted"),
            @ApiResponse(responseCode = "404", description = "Patient not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        var deletePatientCommand = new DeletePatientCommand(id);
        patientCommandService.handle(deletePatientCommand);
        return ResponseEntity.ok("Patient with given id successfully deleted");
    }

    // Nuevo endpoint: Buscar paciente por email
    @GetMapping("/by-email")
    public ResponseEntity<PatientResource> getPatientByEmail(@RequestParam String email) {
        var query = new GetPatientByEmailQuery(email);
        var patient = patientQueryService.handle(query);
        if (patient.isEmpty()) return ResponseEntity.notFound().build();
        var patientResource = PatientResourceFromEntityAssembler.toResourceFromEntity(patient.get());
        return ResponseEntity.ok(patientResource);
    }

    // Nuevo endpoint: Buscar paciente por nombre
    @GetMapping("/by-name")
    public ResponseEntity<PatientResource> getPatientByName(@RequestParam String name) {
        var query = new GetPatientByNameQuery(name);
        var patient = patientQueryService.handle(query);
        if (patient.isEmpty()) return ResponseEntity.notFound().build();
        var patientResource = PatientResourceFromEntityAssembler.toResourceFromEntity(patient.get());
        return ResponseEntity.ok(patientResource);
    }

    // Nuevo endpoint: Buscar paciente por apellido
    @GetMapping("/by-last-name")
    public ResponseEntity<PatientResource> getPatientByLastName(@RequestParam String lastName) {
        var query = new GetPatientByLastNameQuery(lastName);
        var patient = patientQueryService.handle(query);
        if (patient.isEmpty()) return ResponseEntity.notFound().build();
        var patientResource = PatientResourceFromEntityAssembler.toResourceFromEntity(patient.get());
        return ResponseEntity.ok(patientResource);
    }

    // Nuevo endpoint: Actualizar paciente
    @Operation(summary = "Update a Patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient updated"),
            @ApiResponse(responseCode = "404", description = "Patient not found"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PatientResource> updatePatient(@PathVariable Long id, @RequestBody CreatePatientResource createPatientResource) {

        var updatePatientCommand = new UpdatePatientCommand(id, createPatientResource.name(), createPatientResource.lastName(), createPatientResource.email());

        try {
            // Llamar al servicio para actualizar el paciente
            patientCommandService.handle(updatePatientCommand);

            // Obtener el paciente actualizado
            var getPatientByIdQuery = new GetPatientByIdQuery(id);
            var patient = patientQueryService.handle(getPatientByIdQuery);

            // Si no se encuentra el paciente, devolver error 404
            if (patient.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            // Convertir el paciente a un recurso y devolver la respuesta
            var patientResource = PatientResourceFromEntityAssembler.toResourceFromEntity(patient.get());
            return ResponseEntity.ok(patientResource);

        } catch (Exception e) {
            // Si ocurre un error, devolver un error 400
            return ResponseEntity.badRequest().build();
        }
    }
}

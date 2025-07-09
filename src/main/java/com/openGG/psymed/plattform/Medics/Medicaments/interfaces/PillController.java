package com.openGG.psymed.plattform.Medics.Medicaments.interfaces;

import com.openGG.psymed.plattform.Medics.Medicaments.domain.model.commands.DeletePillsCommand;
import com.openGG.psymed.plattform.Medics.Medicaments.domain.model.queries.GetAllPillsQuery;
import com.openGG.psymed.plattform.Medics.Medicaments.domain.model.queries.GetPillsByIdQuery;
import com.openGG.psymed.plattform.Medics.Medicaments.domain.model.queries.GetPillsByPatientId;
import com.openGG.psymed.plattform.Medics.Medicaments.domain.service.PillCommandService;
import com.openGG.psymed.plattform.Medics.Medicaments.domain.service.PillQueryService;
import com.openGG.psymed.plattform.Medics.Medicaments.interfaces.rest.resorces.CreatePillResource;
import com.openGG.psymed.plattform.Medics.Medicaments.interfaces.rest.resorces.PillResource;
import com.openGG.psymed.plattform.Medics.Medicaments.interfaces.rest.transform.CreatePillCommandFromResourceAssembler;
import com.openGG.psymed.plattform.Medics.Medicaments.interfaces.rest.transform.PillResourceFromEntityAssembler;
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
 * Controlador para la gestión de medicamentos.
 * Proporciona endpoints para crear, obtener y eliminar medicamentos.
 */
@RestController
@RequestMapping(value = "/api/v1/pills", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Medication_management", description = "All medication related endpoints")
public class PillController {

    private final PillCommandService pillCommandService;
    private final PillQueryService pillQueryService;

    /**
     * Constructor del controlador de medicamentos.
     *
     * @param pillCommandService Servicio para ejecutar comandos relacionados con medicamentos.
     * @param pillQueryService   Servicio para ejecutar consultas sobre medicamentos.
     */
    public PillController(PillCommandService pillCommandService, PillQueryService pillQueryService) {
        this.pillCommandService = pillCommandService;
        this.pillQueryService = pillQueryService;
    }

    /**
     * Crea un nuevo medicamento.
     *
     * @param createPillResource Recurso con los datos del medicamento a crear.
     * @return ResponseEntity con el medicamento creado o un estado de error.
     */
    @Operation(summary = "Create a new Pill")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pill created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Pill not found")
    })
    @PostMapping
    public ResponseEntity<PillResource> createMedication(@RequestBody CreatePillResource createPillResource) {
        var createMedicationCommand = CreatePillCommandFromResourceAssembler.toCommandFromResource(createPillResource);
        var medicationId = pillCommandService.handle(createMedicationCommand);
        if (medicationId == null || medicationId == 0L) return ResponseEntity.badRequest().build();
        var getMedicationByIdQuery = new GetPillsByIdQuery(medicationId);
        var medication = pillQueryService.handle(getMedicationByIdQuery);

        if (medication.isEmpty()) return ResponseEntity.notFound().build();
        var medicationEntity = medication.get();
        var medicationResource = PillResourceFromEntityAssembler.toResourceFromEntity(medicationEntity);
        return new ResponseEntity<>(medicationResource, HttpStatus.CREATED);
    }

    /**
     * Obtiene todos los medicamentos registrados.
     *
     * @return ResponseEntity con la lista de medicamentos o un estado de error.
     */
    @Operation(summary = "Get all Pills")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pills found"),
            @ApiResponse(responseCode = "404", description = "Pills not found")
    })
    @GetMapping
    public ResponseEntity<List<PillResource>> getAllMedications() {
        System.out.print("hola123");

        var getAllMedicationsQuery = new GetAllPillsQuery();
        var medications = pillQueryService.handle(getAllMedicationsQuery);
        var medicationResources = medications.stream()
                .map(PillResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(medicationResources);
    }

    /**
     * Obtiene los medicamentos de un paciente específico.
     *
     * @param patientId ID del paciente cuyos medicamentos se consultarán.
     * @return ResponseEntity con la lista de medicamentos o un estado de error.
     */
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<PillResource>> getMedicationByPatientId(@PathVariable Long patientId) {
        var getPillsByPatientId = new GetPillsByPatientId(patientId);
        var medications = pillQueryService.handle(getPillsByPatientId);
        if (medications.isEmpty()) return ResponseEntity.notFound().build();
        var medicationResources = medications.stream()
                .map(PillResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(medicationResources);
    }

    /**
     * Elimina un medicamento por su ID.
     *
     * @param pillId ID del medicamento a eliminar.
     * @return ResponseEntity con un mensaje de éxito o error.
     */
    @Operation(summary = "Delete a Pill")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pill deleted"),
            @ApiResponse(responseCode = "404", description = "Pill not found")
    })
    @DeleteMapping("/{pillId}")
    public ResponseEntity<String> deleteMedication(@PathVariable Long pillId) {
        var deleteMedicationCommand = new DeletePillsCommand(pillId);
        pillCommandService.handle(deleteMedicationCommand);
        return ResponseEntity.ok("Medication with given id successfully deleted");
    }
}

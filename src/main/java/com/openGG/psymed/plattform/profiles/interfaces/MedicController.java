package com.openGG.psymed.plattform.profiles.interfaces;
import com.openGG.psymed.plattform.profiles.domain.model.commands.DeleteMedicCommand;
import com.openGG.psymed.plattform.profiles.domain.model.commands.UpdateMedicCommand;
import com.openGG.psymed.plattform.profiles.domain.model.commands.UpdateMedicDescriptionCommand;
import com.openGG.psymed.plattform.profiles.domain.model.queries.*;
import com.openGG.psymed.plattform.profiles.domain.service.MedicCommandService;
import com.openGG.psymed.plattform.profiles.domain.service.MedicQueryService;
import com.openGG.psymed.plattform.profiles.interfaces.rest.resorces.CreateMedicResource;
import com.openGG.psymed.plattform.profiles.interfaces.rest.resorces.MedicResource;
import com.openGG.psymed.plattform.profiles.interfaces.rest.transform.CreateMedicCommandFromResourceAssembler;
import com.openGG.psymed.plattform.profiles.interfaces.rest.transform.MedicResourceFromEntityAssembler;
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
 * Controlador para la gestión de médicos.
 * Proporciona endpoints para crear, obtener y eliminar médicos.
 */
@RestController
@RequestMapping(value = "/api/v1/medics", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Medic", description = "All medic related endpoints")
public class MedicController {

    private final MedicCommandService medicCommandService;
    private final MedicQueryService medicQueryService;

    /**
     * Constructor del controlador de médicos.
     *
     * @param medicCommandService Servicio para ejecutar comandos relacionados con médicos.
     * @param medicQueryService   Servicio para ejecutar consultas sobre médicos.
     */
    public MedicController(MedicCommandService medicCommandService, MedicQueryService medicQueryService) {
        this.medicCommandService = medicCommandService;
        this.medicQueryService = medicQueryService;
    }

    /**
     * Crea un nuevo médico.
     *
     * @param createMedicResource Recurso con los datos del médico a crear.
     * @return ResponseEntity con el médico creado o un estado de error.
     */
    @Operation(summary = "Create a new Medic")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Medic created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Medic not found")
    })
    @PostMapping
    public ResponseEntity<MedicResource> createMedic(@RequestBody CreateMedicResource createMedicResource) {
        var createMedicCommand = CreateMedicCommandFromResourceAssembler.toCommandFromResource(createMedicResource);
        var medicId = medicCommandService.handle(createMedicCommand);
        if (medicId == null || medicId == 0L) return ResponseEntity.badRequest().build();
        var getMedicByIdQuery = new GetMedicByIdQuery(medicId);
        var medic = medicQueryService.handle(getMedicByIdQuery);

        if (medic.isEmpty()) return ResponseEntity.notFound().build();
        var medicEntity = medic.get();
        var medicResource = MedicResourceFromEntityAssembler.toResourceFromEntity(medicEntity);
        return new ResponseEntity<>(medicResource, HttpStatus.CREATED);
    }

    /**
     * Obtiene todos los médicos registrados.
     *
     * @return ResponseEntity con la lista de médicos o un estado de error.
     */
    @Operation(summary = "Get all Medics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medics found"),
            @ApiResponse(responseCode = "404", description = "Medics not found")
    })
    @GetMapping
    public ResponseEntity<List<MedicResource>> getAllMedics() {
        var getAllMedicsQuery = new GetAllMedicsQuery();
        var medics = medicQueryService.handle(getAllMedicsQuery);
        var medicResources = medics.stream()
                .map(MedicResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(medicResources);
    }

    /**
     * Obtiene un médico por su ID.
     *
     * @param id El ID del médico a buscar.
     * @return ResponseEntity con el médico encontrado o un estado de error.
     */
    @GetMapping("/{id}")
    public ResponseEntity<MedicResource> getMedicById(@PathVariable Long id) {
        var getMedicByIdQuery = new GetMedicByIdQuery(id);
        var medic = medicQueryService.handle(getMedicByIdQuery);
        if (medic.isEmpty()) return ResponseEntity.notFound().build();
        var medicResource = MedicResourceFromEntityAssembler.toResourceFromEntity(medic.get());
        return ResponseEntity.ok(medicResource);
    }

    /**
     * Elimina un médico por su ID.
     *
     * @param id El ID del médico a eliminar.
     * @return ResponseEntity con un mensaje de éxito o error.
     */
    @Operation(summary = "Delete a Medic")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medic deleted"),
            @ApiResponse(responseCode = "404", description = "Medic not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedic(@PathVariable Long id) {
        var deleteMedicCommand = new DeleteMedicCommand(id);
        medicCommandService.handle(deleteMedicCommand);
        return ResponseEntity.ok("Medic with given id successfully deleted");
    }

    // Nuevo endpoint: Buscar médico por email
    @GetMapping("/by-email")
    public ResponseEntity<MedicResource> getMedicByEmail(@RequestParam String email) {
        var query = new GetMedicByEmailQuery(email);
        var medic = medicQueryService.handle(query);
        if (medic.isEmpty()) return ResponseEntity.notFound().build();
        var medicResource = MedicResourceFromEntityAssembler.toResourceFromEntity(medic.get());
        return ResponseEntity.ok(medicResource);
    }

    // Nuevo endpoint: Buscar médico por nombre
    @GetMapping("/by-name")
    public ResponseEntity<MedicResource> getMedicByName(@RequestParam String name) {
        var query = new GetMedicByNameQuery(name);
        var medic = medicQueryService.handle(query);
        if (medic.isEmpty()) return ResponseEntity.notFound().build();
        var medicResource = MedicResourceFromEntityAssembler.toResourceFromEntity(medic.get());
        return ResponseEntity.ok(medicResource);
    }

    // Nuevo endpoint: Buscar médico por apellido
    @GetMapping("/by-last-name")
    public ResponseEntity<MedicResource> getMedicByLastName(@RequestParam String lastName) {
        var query = new GetMedicByLastNameQuery(lastName);
        var medic = medicQueryService.handle(query);
        if (medic.isEmpty()) return ResponseEntity.notFound().build();
        var medicResource = MedicResourceFromEntityAssembler.toResourceFromEntity(medic.get());
        return ResponseEntity.ok(medicResource);
    }

    // Nuevo endpoint: Actualizar médico
    @Operation(summary = "Update a Medic")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medic updated"),
            @ApiResponse(responseCode = "404", description = "Medic not found"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PutMapping("/{id}")
    public ResponseEntity<MedicResource> updateMedic(@PathVariable Long id, @RequestBody CreateMedicResource createMedicResource) {
        // Crear un comando de actualización de médico con el id proporcionado
        var updateMedicCommand = new UpdateMedicCommand(id, createMedicResource.name(), createMedicResource.lastName(), createMedicResource.email(), createMedicResource.phone(), createMedicResource.specialty(), createMedicResource.address());

        try {
            // Llamar al servicio para actualizar el médico
            medicCommandService.handle(updateMedicCommand);

            // Obtener el médico actualizado
            var getMedicByIdQuery = new GetMedicByIdQuery(id);
            var medic = medicQueryService.handle(getMedicByIdQuery);

            // Si no se encuentra el médico, devolver error 404
            if (medic.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            // Convertir el médico a un recurso y devolver la respuesta
            var medicResource = MedicResourceFromEntityAssembler.toResourceFromEntity(medic.get());
            return ResponseEntity.ok(medicResource);

        } catch (Exception e) {
            // Si ocurre un error, devolver un error 400
            return ResponseEntity.badRequest().build();
        }
    }
    @Operation(summary = "Update a description about the medic")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Description updated"),
            @ApiResponse(responseCode = "404", description = "Medic not found"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PatchMapping("/{id}/description")
    public ResponseEntity<Void> updateDescription(@PathVariable Long id, @RequestBody UpdateMedicDescriptionCommand command) {
        var updateMedicDescriptionCommand = new UpdateMedicDescriptionCommand(id, command.description());

        try {
            medicCommandService.handle(updateMedicDescriptionCommand);

            var getMedicByIdQuery = new GetMedicByIdQuery(id);
            var medic = medicQueryService.handle(getMedicByIdQuery);

            // Si no se encuentra el médico, devolver error 404
            if (medic.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // Si ocurre un error, devolver un error 400
            return ResponseEntity.badRequest().build();
        }
    }
}

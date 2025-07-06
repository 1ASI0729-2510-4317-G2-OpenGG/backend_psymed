package com.openGG.psymed.plattform.profiles.application.internal.commandservice;

import com.openGG.psymed.plattform.profiles.domain.model.aggregates.Medic;
import com.openGG.psymed.plattform.profiles.domain.model.commands.*;
import com.openGG.psymed.plattform.profiles.domain.service.MedicCommandService;
import com.openGG.psymed.plattform.profiles.infratructure.persistence.jpa.repositories.MedicRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicCommandServiceImpl implements MedicCommandService {

    private final MedicRepository medicRepository;

    // Constructor con inyección de dependencias
    public MedicCommandServiceImpl(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    @Override
    public Long handle(CreateMedicCommand command) {
        // Verificar si ya existe un médico con el mismo correo electrónico
        if (medicRepository.existsByEmail(command.email())) {
            throw new IllegalArgumentException("There is a medic with the same email");
        }

        // Creación del médico a partir del comando
        var medic = new Medic(command.name(), command.lastName(), command.email(), command.phone(), command.specialty(), command.address());

        try {
            // Guardar en base de datos
            medicRepository.save(medic);
            return medic.getId();
        } catch (Exception e) {
            // Manejo de error con mensaje claro
            throw new RuntimeException(String.format("Error creating the medic: %s", e.getMessage()));
        }
    }

    @Override
    public void handle(DeleteMedicCommand command) {
        // Verificar si el médico existe en la base de datos
        if (!medicRepository.existsById(command.medicId())) {
            throw new IllegalStateException("The medic doesn't exist");
        }

        try {
            // Eliminar el médico
            medicRepository.deleteById(command.medicId());
        } catch (Exception e) {
            // Manejo de error durante la eliminación
            throw new RuntimeException("An error occurred during delete: " + e.getMessage());
        }
    }

    @Override
    public void handle(UpdateMedicCommand command) {
        // Verificación de existencia del médico
        var medic = medicRepository.findById(command.medicId())
                .orElseThrow(() -> new IllegalStateException("The medic does not exist"));

        // Crear un nuevo objeto Medic con los valores actualizados
        medic = new Medic(command.name(), command.lastName(), command.email(), command.phone(), command.specialty(), command.address());

        try {
            // Guardar el médico actualizado
            medicRepository.save(medic);
        } catch (Exception e) {
            // Manejo de error durante la actualización
            throw new RuntimeException("An error occurred during update: " + e.getMessage());
        }
    }
}

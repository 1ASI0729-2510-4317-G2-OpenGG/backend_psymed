package com.openGG.psymed.plattform.profiles_management.application.internal.commandservice;

import com.openGG.psymed.plattform.profiles_management.domain.model.aggregates.Patient;
import com.openGG.psymed.plattform.profiles_management.domain.model.commands.*;
import com.openGG.psymed.plattform.profiles_management.domain.service.PatientCommandService;
import com.openGG.psymed.plattform.profiles_management.infratructure.persistence.jpa.repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientCommandServiceImpl implements PatientCommandService {

    private final PatientRepository patientRepository;

    // Constructor con inyección de dependencias
    public PatientCommandServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Long handle(CreatePatientCommand command) {
        // Verificar si ya existe un paciente con el mismo correo electrónico
        if (patientRepository.existsByEmail(command.email())) {
            throw new IllegalArgumentException("There is a patient with the same email");
        }

        // Creación del paciente a partir del comando
        var patient = new Patient(command.name(), command.lastName(), command.email());

        try {
            // Guardar en base de datos
            patientRepository.save(patient);
            return patient.getId();
        } catch (Exception e) {
            // Manejo de error con mensaje claro
            throw new RuntimeException(String.format("Error creating the patient: %s", e.getMessage()));
        }
    }

    @Override
    public void handle(DeletePatientCommand command) {
        // Verificar si el paciente existe en la base de datos
        if (!patientRepository.existsById(command.patientId())) {
            throw new IllegalStateException("The patient doesn't exist");
        }

        try {
            // Eliminar el paciente
            patientRepository.deleteById(command.patientId());
        } catch (Exception e) {
            // Manejo de error durante la eliminación
            throw new RuntimeException("An error occurred during delete: " + e.getMessage());
        }
    }

    @Override
    public void handle(UpdatePatientCommand command) {
        // Verificación de existencia del paciente
        var patient = patientRepository.findById(command.patientId())
                .orElseThrow(() -> new IllegalStateException("The patient does not exist"));

        // Crear un nuevo objeto Patient con los valores actualizados
        patient = new Patient(command.name(), command.lastName(), command.email());

        try {
            // Guardar el paciente actualizado
            patientRepository.save(patient);
        } catch (Exception e) {
            // Manejo de error durante la actualización
            throw new RuntimeException("An error occurred during update: " + e.getMessage());
        }
    }
}

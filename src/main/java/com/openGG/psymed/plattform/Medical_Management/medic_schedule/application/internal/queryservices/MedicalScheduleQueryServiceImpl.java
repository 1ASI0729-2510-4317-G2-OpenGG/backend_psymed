package com.openGG.psymed.plattform.Medical_Management.medic_schedule.application.internal.queryservices;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.aggregates.MedicalSchedule;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.services.MedicalScheduleQueryService;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.infrastructure.persistence.jpa.repositories.MedicalScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application service implementation that handles queries related to {@link MedicalSchedule}.
 * <p>
 * Provides methods to retrieve medical schedules from the database.
 * </p>
 */
@Service
public class MedicalScheduleQueryServiceImpl implements MedicalScheduleQueryService {

    private final MedicalScheduleRepository repository;

    /**
     * Constructs a new {@code MedicalScheduleQueryServiceImpl} with the given repository.
     *
     * @param repository the JPA repository used to retrieve {@code MedicalSchedule} entities
     */
    public MedicalScheduleQueryServiceImpl(MedicalScheduleRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieves a list of medical schedules associated with the specified patient.
     *
     * @param patientId the unique identifier of the patient
     * @return a list of {@link MedicalSchedule} entities associated with the given patient ID
     */
    @Override
    public List<MedicalSchedule> getSchedulesByPatientId(Long patientId) {
        return repository.findByPatientId(patientId);
    }
}
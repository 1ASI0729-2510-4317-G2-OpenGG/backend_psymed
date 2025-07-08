package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.application.internal.queryservices;

import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.domain.model.queries.GetSchedulesByPatientIdQuery;
import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.infrastructure.acl.external.resources.MedicalScheduleContextFacade;
import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.interfaces.rest.resources.ScheduleViewResource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application service that handles queries to retrieve medical schedules for a patient.
 * This service communicates with an external context facade to fetch data from another bounded context.
 */

@Service
public class ViewMedicalSchedulesQueryService {

    private final MedicalScheduleContextFacade scheduleContext;

    public ViewMedicalSchedulesQueryService(MedicalScheduleContextFacade scheduleContext) {
        this.scheduleContext = scheduleContext;
    }

    public List<ScheduleViewResource> handle(GetSchedulesByPatientIdQuery query) {
        return scheduleContext.getSchedulesByPatientId(query.patientId()).stream()
                .map(schedule -> new ScheduleViewResource(
                        schedule.id(),
                        schedule.patientId(),
                        schedule.background(),
                        schedule.consultationReason(),
                        schedule.consultationDate(),
                        schedule.medicId()
                )).toList();
    }
}
package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.application.internal.queryservices;

import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.domain.model.queries.GetPillsByPatientIdQuery;
import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.infrastructure.acl.external.resources.MedicationContextFacade;
import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.interfaces.rest.resources.PillViewResource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application service that handles queries to retrieve a patient's prescribed pills.
 * This service uses a context facade to communicate with the medication management subsystem.
 */

@Service
public class ViewPatientPillsQueryService {

    private final MedicationContextFacade pillContext;

    public ViewPatientPillsQueryService(MedicationContextFacade pillContext) {
        this.pillContext = pillContext;
    }

    public List<PillViewResource> handle(GetPillsByPatientIdQuery query) {
        return pillContext.getPillsByPatientId(query.patientId()).stream()
                .map(pill -> new PillViewResource(
                        pill.id(),
                        pill.name(),
                        pill.description(),
                        pill.patientId(),
                        pill.interval(),
                        pill.quantity()
                )).toList();
    }
}
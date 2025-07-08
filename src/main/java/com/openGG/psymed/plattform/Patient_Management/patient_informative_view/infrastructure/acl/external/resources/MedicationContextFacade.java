package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.infrastructure.acl.external.resources;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Anti-Corruption Layer (ACL) component that provides access to pill/medication data
 * from an external module or service. Intended to isolate the internal patient
 * informative view context from the external medication context.
 */

@Service
public class MedicationContextFacade {

    public List<PillResource> getPillsByPatientId(Long patientId) {
        return List.of();
    }
}
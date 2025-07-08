package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.infrastructure.acl.external.resources;

/**
 * Data Transfer Object (DTO) representing a pill (medication) resource
 * retrieved from an external medication context or service.
 *
 * <p>This record is used by the ACL (Anti-Corruption Layer) to transport pill data
 * without exposing internal domain logic.</p>
 *
 * @param id          the unique identifier of the pill
 * @param name        the name of the medication
 * @param description a brief description of the medication
 * @param patientId   the ID of the patient assigned to this pill
 * @param interval    how often the medication should be taken (e.g., "Every 8 hours")
 * @param quantity    the quantity or dosage of the medication (e.g., "500mg")
 */
public record PillResource(
        Long id,
        String name,
        String description,
        Long patientId,
        String interval,
        String quantity
) {}

package com.openGG.psymed.plattform.Medics.medic_sections.domain.model.queries;

/**
 * Query object used to retrieve all medical sections for a specific patient.
 * Typically used in the application layer to trigger a query service.
 *
 * @param patientId the unique identifier of the patient whose sections are to be retrieved
 */

public record GetSectionsByPatientIdQuery(Long patientId) { }
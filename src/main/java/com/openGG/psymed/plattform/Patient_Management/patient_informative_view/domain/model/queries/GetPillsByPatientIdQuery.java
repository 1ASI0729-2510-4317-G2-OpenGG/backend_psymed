package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.domain.model.queries;

/**
 * Query object used to retrieve all pills associated with a specific patient.
 * This record is part of the patient's informative view context and supports
 * the query layer in a DDD-compliant architecture.
 *
 * @param patientId the unique identifier of the patient whose pills are being requested
 */

public record GetPillsByPatientIdQuery(Long patientId) {}
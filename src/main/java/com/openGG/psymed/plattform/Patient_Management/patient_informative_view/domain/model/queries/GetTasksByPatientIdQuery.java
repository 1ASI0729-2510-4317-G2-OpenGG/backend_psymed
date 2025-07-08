package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.domain.model.queries;

/**
 * Query object used to retrieve all tasks associated with a specific patient.
 * This record is part of the patient's informative view context and is used
 * by the query service to fetch task-related data.
 *
 * @param patientId the unique identifier of the patient whose tasks are being requested
 */

public record GetTasksByPatientIdQuery(Long patientId) {}
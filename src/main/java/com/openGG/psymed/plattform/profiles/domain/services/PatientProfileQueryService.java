package com.openGG.psymed.plattform.profiles.domain.services;


import com.openGG.psymed.plattform.profiles.domain.model.aggregates.PatientProfile;
import com.openGG.psymed.plattform.profiles.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface PatientProfileQueryService {
    Optional<PatientProfile> handle(GetPatientProfileByIdQuery query);
    Optional<PatientProfile> handle(GetPatientProfileByAccountIdQuery query);
    List<PatientProfile> handle(GetAllPatientProfilesQuery query);
    Long handle(GetClinicalHistoryIdByPatientIdQuery query);
    List<PatientProfile> handle(GetPatientProfileByProfessionalIdQuery query);

}

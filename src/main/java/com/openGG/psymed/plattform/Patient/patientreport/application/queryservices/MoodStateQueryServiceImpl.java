package com.openGG.psymed.plattform.Patient.patientreport.application.queryservices;

import com.openGG.psymed.plattform.Patient.patientreport.domain.model.aggregates.MoodState;
import com.openGG.psymed.plattform.Patient.patientreport.domain.model.queries.GetAllMoodStatesByPatientIdQuery;
import com.openGG.psymed.plattform.Patient.patientreport.domain.services.MoodStateQueryService;
import com.openGG.psymed.plattform.Patient.patientreport.infrastructure.persistence.jpa.repositories.MoodStateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoodStateQueryServiceImpl implements MoodStateQueryService {
    private final MoodStateRepository moodStateRepository;

    public MoodStateQueryServiceImpl(MoodStateRepository moodStateRepository) {
        this.moodStateRepository = moodStateRepository;
    }
    @Override
    public List<MoodState> handle(GetAllMoodStatesByPatientIdQuery query) {
        return moodStateRepository.findAllByPatientId(query.patientId());
    }
}

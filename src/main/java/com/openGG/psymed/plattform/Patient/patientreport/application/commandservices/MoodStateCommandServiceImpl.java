    package com.openGG.psymed.plattform.Patient.patientreport.application.commandservices;

    import com.openGG.psymed.plattform.Patient.patientreport.application.outboundservices.ExternalProfileService;
    import com.openGG.psymed.plattform.Patient.patientreport.application.outboundservices.acl.ExternalProfileServiceImpl;
    import com.openGG.psymed.plattform.Patient.patientreport.domain.exceptions.PatientNotFoundException;
    import com.openGG.psymed.plattform.Patient.patientreport.domain.model.aggregates.MoodState;
    import com.openGG.psymed.plattform.Patient.patientreport.domain.model.commands.CreateMoodStateRecordCommand;
    import com.openGG.psymed.plattform.Patient.patientreport.domain.services.MoodStateCommandService;
    import com.openGG.psymed.plattform.Patient.patientreport.infrastructure.persistence.jpa.repositories.MoodStateRepository;
    import org.springframework.stereotype.Service;

    import java.util.Optional;

    @Service
    public class MoodStateCommandServiceImpl implements MoodStateCommandService {

        private final MoodStateRepository moodStateRecordRepository;
        private final ExternalProfileService externalProfileService;

        public MoodStateCommandServiceImpl(MoodStateRepository moodStateRepository, ExternalProfileServiceImpl externalProfileService) {
            this.moodStateRecordRepository = moodStateRepository;
            this.externalProfileService = externalProfileService;
        }
        @Override
        public Optional<MoodState> handle(CreateMoodStateRecordCommand command) {

            var patientIdExists = externalProfileService.existsPatientById(command.patientId());
            if(patientIdExists) {
                var moodStateRecord = new MoodState(command.patientId(), command.moodStatus());
                var lastMoodStateRecord = moodStateRecordRepository
                        .findAllByPatientId(moodStateRecord.getPatientId())
                        .stream().reduce((first, second) -> second).orElse(null);

                if(lastMoodStateRecord != null) moodStateRecord.validateRecordAvailability(lastMoodStateRecord);

                try {
                    var createdMoodStateRecord = moodStateRecordRepository.save(moodStateRecord);
                    return Optional.of(createdMoodStateRecord);

                }catch(Exception e) {
                    throw new IllegalArgumentException("Error creating the mood state record: %s"
                            .formatted(e.getMessage()));
                }
            }
            throw new PatientNotFoundException(command.patientId());




        }
    }

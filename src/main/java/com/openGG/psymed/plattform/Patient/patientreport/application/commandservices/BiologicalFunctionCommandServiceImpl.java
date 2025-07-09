package com.openGG.psymed.plattform.Patient.patientreport.application.commandservices;

import com.openGG.psymed.plattform.Patient.patientreport.application.outboundservices.ExternalProfileService;
import com.openGG.psymed.plattform.Patient.patientreport.application.outboundservices.acl.ExternalProfileServiceImpl;
import com.openGG.psymed.plattform.Patient.patientreport.domain.exceptions.PatientNotFoundException;
import com.openGG.psymed.plattform.Patient.patientreport.domain.model.aggregates.BiologicalFunction;
import com.openGG.psymed.plattform.Patient.patientreport.domain.model.commands.CreateBiologicalFunctionRecordCommand;
import com.openGG.psymed.plattform.Patient.patientreport.domain.services.BiologicalFunctionCommandService;
import com.openGG.psymed.plattform.Patient.patientreport.infrastructure.persistence.jpa.repositories.BiologicalFunctionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BiologicalFunctionCommandServiceImpl implements BiologicalFunctionCommandService {
    private final BiologicalFunctionRepository biologicalFunctionRepository;
    private final ExternalProfileService externalProfileService;

    public BiologicalFunctionCommandServiceImpl(BiologicalFunctionRepository biologicalFunctionRepository,
                                                ExternalProfileServiceImpl externalProfileService){
        this.biologicalFunctionRepository = biologicalFunctionRepository;
        this.externalProfileService = externalProfileService;

    }

    @Override
    public Optional<BiologicalFunction> handle(CreateBiologicalFunctionRecordCommand command) {
        var patientIdExists = externalProfileService.existsPatientById(command.patientId());

        if(patientIdExists) {
            var biologicalFunctionRecord = new BiologicalFunction(command);
            var lastBiologicalFunctionRecord = biologicalFunctionRepository
                    .findAllByPatientId(biologicalFunctionRecord.getPatientId())
                    .stream().reduce((first, second) -> second).orElse(null);

            if(lastBiologicalFunctionRecord != null)
                biologicalFunctionRecord.validateRecordAvailability(lastBiologicalFunctionRecord);

            try {
                var createdBiologicalFunctionRecord = biologicalFunctionRepository.save(biologicalFunctionRecord);
                return Optional.of(createdBiologicalFunctionRecord);
            }catch(Exception e){
                throw new IllegalArgumentException("Error creating the biological function record: %s"
                        .formatted(e.getMessage()));
            }
        }
        throw new PatientNotFoundException(command.patientId());
    }
}

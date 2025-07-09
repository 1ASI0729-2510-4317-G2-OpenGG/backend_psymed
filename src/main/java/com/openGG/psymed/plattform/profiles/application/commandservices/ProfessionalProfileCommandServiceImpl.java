package com.openGG.psymed.plattform.profiles.application.commandservices;

import com.openGG.psymed.plattform.profiles.application.outboundservices.acl.ExternalAccountService;
import com.openGG.psymed.plattform.profiles.domain.model.aggregates.ProfessionalProfile;
import com.openGG.psymed.plattform.profiles.domain.model.commands.CheckProfessionalProfileByIdCommand;
import com.openGG.psymed.plattform.profiles.domain.model.commands.CreateProfessionalProfileCommand;
import com.openGG.psymed.plattform.profiles.domain.model.valueobjects.Email;
import com.openGG.psymed.plattform.profiles.domain.services.ProfessionalProfileCommandService;
import com.openGG.psymed.plattform.profiles.infrastructure.persistence.jpa.repositories.PatientProfileRepository;
import com.openGG.psymed.plattform.profiles.infrastructure.persistence.jpa.repositories.ProfessionalProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class ProfessionalProfileCommandServiceImpl implements ProfessionalProfileCommandService {

    private final ProfessionalProfileRepository professionalProfileRepository;
    private final PatientProfileRepository patientProfileRepository;
    private final ExternalAccountService externalAccountService;

    public ProfessionalProfileCommandServiceImpl(ProfessionalProfileRepository professionalProfileRepository,
                                                 PatientProfileRepository patientProfileRepository,
                                                 ExternalAccountService externalAccountService) {
        this.professionalProfileRepository = professionalProfileRepository;
        this.patientProfileRepository = patientProfileRepository;
        this.externalAccountService = externalAccountService;
    }

    @Override
    @Transactional
    public Optional<ProfessionalProfile> handle(CreateProfessionalProfileCommand command) {
        var emailAddress = new Email(command.email());
        if(professionalProfileRepository.existsByEmail(emailAddress) || patientProfileRepository.existsByEmail(emailAddress))
            throw new IllegalArgumentException("Email already exists");

        var accountId = externalAccountService.createAccount(command.username(), command.password(), "ROLE_PROFESSIONAL");

        var profile = new ProfessionalProfile(command, accountId.get());

        professionalProfileRepository.save(profile);

        return Optional.of(profile);
    }

    @Override
    public boolean handle(CheckProfessionalProfileByIdCommand command) {
        return this.professionalProfileRepository.existsById(command.id());
    }
}

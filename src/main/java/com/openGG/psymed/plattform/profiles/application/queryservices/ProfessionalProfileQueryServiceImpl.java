package com.openGG.psymed.plattform.profiles.application.queryservices;

import com.openGG.psymed.plattform.profiles.domain.model.aggregates.ProfessionalProfile;
import com.openGG.psymed.plattform.profiles.domain.model.queries.GetProfessionalProfileByAccountIdQuery;
import com.openGG.psymed.plattform.profiles.domain.model.queries.GetProfessionalProfileByIdQuery;
import com.openGG.psymed.plattform.profiles.domain.services.ProfessionalProfileQueryService;
import com.openGG.psymed.plattform.profiles.infrastructure.persistence.jpa.repositories.ProfessionalProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessionalProfileQueryServiceImpl implements ProfessionalProfileQueryService {
    private final ProfessionalProfileRepository professionalProfileRepository;

    public ProfessionalProfileQueryServiceImpl(ProfessionalProfileRepository professionalProfileRepository){
        this.professionalProfileRepository = professionalProfileRepository;
    }

    @Override
    public Optional<ProfessionalProfile> handle(GetProfessionalProfileByIdQuery query) {
        return professionalProfileRepository.findById(query.id());
    }

    public Optional<ProfessionalProfile> handle(GetProfessionalProfileByAccountIdQuery query) {
        return professionalProfileRepository.findByAccountId(query.accountId());
    }
}

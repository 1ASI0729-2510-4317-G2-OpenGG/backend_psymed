package com.openGG.psymed.plattform.Patient_Management.patientreport.application.outboundservices.acl;

import com.openGG.psymed.plattform.Patient_Management.patientreport.application.outboundservices.ExternalProfileService;
import com.openGG.psymed.plattform.profiles.interfaces.acl.ProfilesContextFacade;
import com.openGG.psymed.plattform.profiles.interfaces.acl.service.ProfilesContextFacadeImpl;
import org.springframework.stereotype.Service;

@Service
public class ExternalProfileServiceImpl implements ExternalProfileService {
    private final ProfilesContextFacade profilesContextFacade;

    public ExternalProfileServiceImpl(ProfilesContextFacadeImpl profilesContextFacade) {
        this.profilesContextFacade = profilesContextFacade;
    }

    public boolean existsPatientById(Long patientId) {
        return  profilesContextFacade.verifyPatientProfile(patientId);
    }
}

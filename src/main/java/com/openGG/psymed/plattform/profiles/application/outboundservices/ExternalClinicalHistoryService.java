package com.openGG.psymed.plattform.profiles.application.outboundservices;

import java.time.LocalDate;

public interface ExternalClinicalHistoryService {
    public long createClinicalHistory(String background, String consultationReason, LocalDate consultationDate);
}

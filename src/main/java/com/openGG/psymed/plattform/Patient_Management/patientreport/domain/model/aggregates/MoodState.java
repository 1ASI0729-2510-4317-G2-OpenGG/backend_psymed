package com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.aggregates;


import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.valueobjects.MoodStatus;
import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.valueobjects.PatientId;
import com.openGG.psymed.plattform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.openGG.psymed.plattform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Entity
@EntityListeners(AuditableModel.class)
public class MoodState extends AuditableAbstractAggregateRoot<MoodState> {
    @NotNull
    MoodStatus moodStatus;

    @Getter
    @NotNull
    @Embedded
    private PatientId patientId;

    public MoodState() {
        this.patientId = null;
        this.moodStatus = null;
    }

    public MoodState(Long patientId, Integer moodStatus) {
        this.patientId = new PatientId(patientId);
        validateMoodStatus(moodStatus);
        switch(moodStatus) {
            case 0:
                this.moodStatus = MoodStatus.SOSAD;
                break;
            case 1:
                this.moodStatus = MoodStatus.SAD;
                break;
            case 2:
                this.moodStatus = MoodStatus.NORMAL;
                break;
            case 3:
                this.moodStatus = MoodStatus.HAPPY;
                break;
            case 4:
                this.moodStatus = MoodStatus.SOHAPPY;
                break;
            default: throw new IllegalArgumentException("Invalid mood status");
        }
    }

    private void validateMoodStatus(Integer moodStatus) {
        if(moodStatus == null || moodStatus < 0 || moodStatus > 4)
            throw new IllegalArgumentException("Invalid mood status");
    }

    public void validateRecordAvailability(MoodState lastMoodState) {
        Date actualDate = new Date();

        LocalDate currentDay = actualDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate lastMoodStateDate = lastMoodState.getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (Objects.equals(currentDay, lastMoodStateDate))
            throw new IllegalArgumentException("You can't record mood state twice in the same day");
    }

    public Integer getStatus() {
        return this.moodStatus.ordinal();
    }

    public Long getLongPatientId() {
        return this.patientId.patientId();
    }


}

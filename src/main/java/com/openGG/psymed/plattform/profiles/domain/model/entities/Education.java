package com.openGG.psymed.plattform.profiles.domain.model.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Education {
    private String degree;
    private String institution;
    private String year;

    public Education() {

    }

    public Education(String degree, String institution, String year) {
        this.degree = degree;
        this.institution = institution;
        this.year = year;
    }
}

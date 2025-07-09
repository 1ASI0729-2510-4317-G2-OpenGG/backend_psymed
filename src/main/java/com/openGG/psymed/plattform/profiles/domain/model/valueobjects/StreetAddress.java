package com.openGG.psymed.plattform.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StreetAddress(String street, String city, String country) {

    public StreetAddress() {
        this(null, null, null);
    }
    public StreetAddress {
        if(street == null || street.isBlank())
            throw new IllegalArgumentException("Street cannot be null or empty");
        if(city == null || city.isBlank())
            throw new IllegalArgumentException("City cannot be null or empty");
        if(country == null || country.isBlank())
            throw new IllegalArgumentException("Country cannot be null or empty");
    }

    public String getStreetAddress(){
        return String.format("%s %s %s", street, city, country);
    }
}

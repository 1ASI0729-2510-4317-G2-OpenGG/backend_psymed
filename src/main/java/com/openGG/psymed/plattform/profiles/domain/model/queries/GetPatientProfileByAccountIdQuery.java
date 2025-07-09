package com.openGG.psymed.plattform.profiles.domain.model.queries;


import com.openGG.psymed.plattform.profiles.domain.model.valueobjects.AccountId;

public record GetPatientProfileByAccountIdQuery(AccountId accountId) {
}

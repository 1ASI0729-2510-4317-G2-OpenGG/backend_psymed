package com.openGG.psymed.plattform.iam.infrastructure.hashing.bcrypt;

import com.openGG.psymed.plattform.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}

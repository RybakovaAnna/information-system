package ru.ibs.training.informationsystem.services.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    //  Authorization
    String generateAccessToken(UserDetails user);
    String validateAccessToken(String token);

    //  Service
//    boolean validateTokenAndPutSecurityContext(String token);
}

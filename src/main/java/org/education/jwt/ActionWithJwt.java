package org.education.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.education.dto.user.AuthenticatedUserDto;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Component
public class ActionWithJwt {

    private final Algorithm algorithm = Algorithm.HMAC512("secret");

    public String createJwtForUser(AuthenticatedUserDto authenticatedUserDto) {
        LocalDateTime timeNow = LocalDateTime.now();
        Instant startLifeJwt = timeNow.atZone(ZoneId.systemDefault()).toInstant();
        Instant endLifeJwt = timeNow.plusMinutes(30).atZone(ZoneId.systemDefault()).toInstant();


        return JWT
                .create()
                .withJWTId(UUID.randomUUID().toString())
                .withIssuer(authenticatedUserDto.getEmail())
                .withNotBefore(startLifeJwt)
                .withExpiresAt(endLifeJwt)
                .sign(algorithm);
    }

    public boolean validateToken(String token) {
        try {
            JWTVerifier jwtVerifier = JWT.require(algorithm)
                    .withIssuer(getEmailByToken(token))
                    .build();
            jwtVerifier.verify(token);
        } catch (Exception msg) {
            return false;
        }
        return true;
    }

    public String getEmailByToken(String token) {
        return JWT.decode(token).getIssuer();
    }
}

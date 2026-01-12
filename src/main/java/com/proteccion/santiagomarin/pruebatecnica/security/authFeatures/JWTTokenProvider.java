package com.proteccion.santiagomarin.pruebatecnica.security.authFeatures;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JWTTokenProvider {

    private static final long EXPIRATION_MS = 3600000; // 1 hora
    private static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();

    public String generateToken(Authentication auth) {
        var user = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
        List<String> roles = auth.getAuthorities()
            .stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());

        return Jwts.builder()
            .subject(user.getUsername())
            .claim("roles", roles)
            .issuedAt(Date.valueOf(LocalDate.now()))
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
            .signWith(SECRET_KEY)
            .compact();
    }

    public Claims validateToken(String token) throws JwtException {
        return Jwts.parser()
            .verifyWith(SECRET_KEY)
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }
}

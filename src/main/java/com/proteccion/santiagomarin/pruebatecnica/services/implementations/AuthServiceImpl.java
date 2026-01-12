package com.proteccion.santiagomarin.pruebatecnica.services.implementations;

import com.proteccion.santiagomarin.pruebatecnica.security.authFeatures.JWTTokenProvider;
import com.proteccion.santiagomarin.pruebatecnica.services.abstractions.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTTokenProvider jwtTokenProvider;

    @Override
    public String login(String correo, String clave) {
        Authentication authentication = this.authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(correo, clave)
        );

        return this.jwtTokenProvider.generateToken(authentication);
    }
}

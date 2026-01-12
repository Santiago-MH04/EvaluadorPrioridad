package com.proteccion.santiagomarin.pruebatecnica.controllers;

import com.proteccion.santiagomarin.pruebatecnica.dto.dtoAuthentication.LoginRequestDTO;
import com.proteccion.santiagomarin.pruebatecnica.services.abstractions.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(
        @RequestBody LoginRequestDTO request,
        HttpServletResponse response
    ) {
        String token = this.authService.login(request.correo(), request.clave());
        response.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        return ResponseEntity.ok(Map.of(
            "correo", request.correo(),
            "token", token,
            "mensaje", "inicio de sesión exitoso"
        ));
    }
}

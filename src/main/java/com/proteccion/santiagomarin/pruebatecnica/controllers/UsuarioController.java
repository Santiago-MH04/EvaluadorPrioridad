package com.proteccion.santiagomarin.pruebatecnica.controllers;

import com.proteccion.santiagomarin.pruebatecnica.dto.dtoRequests.UsuarioDTO;
import com.proteccion.santiagomarin.pruebatecnica.dto.mappers.UsuarioMapper;
import com.proteccion.santiagomarin.pruebatecnica.entities.Usuario;
import com.proteccion.santiagomarin.pruebatecnica.services.abstractions.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = this.usuarioMapper.toEntity(usuarioDTO);
        Usuario saved = this.usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(this.usuarioMapper.toDTO(saved));
    }
}

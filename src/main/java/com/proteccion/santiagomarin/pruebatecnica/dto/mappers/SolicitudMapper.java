package com.proteccion.santiagomarin.pruebatecnica.dto.mappers;

import com.proteccion.santiagomarin.pruebatecnica.dto.dtoRequests.SolicitudDTO;
import com.proteccion.santiagomarin.pruebatecnica.entities.Solicitud;
import com.proteccion.santiagomarin.pruebatecnica.entities.Usuario;
import com.proteccion.santiagomarin.pruebatecnica.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class SolicitudMapper {

    public final UsuarioRepository repoUsuario;

    public Solicitud toEntity(SolicitudDTO solicitudDTO){
        Usuario usuario = this.repoUsuario.findByCorreo(solicitudDTO.correo())
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                String.format("Usuario con correo '%s' no encontrado", solicitudDTO.correo())
            ));

        return Solicitud.builder()
            .tipo(solicitudDTO.tipo())
            .prioridadManual(solicitudDTO.prioridadManual())
            .usuario(usuario)
            .build();
    }
}

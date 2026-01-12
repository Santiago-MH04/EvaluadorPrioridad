package com.proteccion.santiagomarin.pruebatecnica.dto.dtoRequests;

import com.proteccion.santiagomarin.pruebatecnica.entities.utils.TipoSolicitud;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SolicitudDTO(
    @NotNull(message = "Tipo es obligatorio") TipoSolicitud tipo,
    Integer prioridadManual,
    @NotBlank(message = "Correo es obligatorio") @Email String correo
) {}

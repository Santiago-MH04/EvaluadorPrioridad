package com.proteccion.santiagomarin.pruebatecnica.dto;

import com.proteccion.santiagomarin.pruebatecnica.entities.utils.TipoSolicitud;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NuevaSolicitudDTO(
    @NotBlank String titulo,
    @NotBlank String descripcion,
    @NotNull TipoSolicitud tipo,
    @NotBlank String usuarioCreador
) {}

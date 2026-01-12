package com.proteccion.santiagomarin.pruebatecnica.dto.dtoAuthentication;

public record LoginRequestDTO(
    String correo,
    String clave
) {
}

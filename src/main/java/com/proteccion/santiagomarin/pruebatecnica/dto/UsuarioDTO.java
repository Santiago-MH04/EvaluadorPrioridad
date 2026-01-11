package com.proteccion.santiagomarin.pruebatecnica.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
    @NotBlank(message = "nombre es obligatorio")
    @Size(min = 2, max = 50, message = "Nombre debe tener entre 2 y 50 caracteres")
    String nombre,

    @NotBlank(message = "apellido es obligatorio")
    @Size(min = 2, max = 50, message = "Apellido debe tener entre 2 y 50 caracteres")
    String apellido,

    @NotBlank(message = "Correo es obligatorio")
    @Email(message = "Correo debe tener formato de correo válido válido")
    String correo,

    @NotBlank(message = "Contraseña es obligatoria")
    @Size(min = 8, max = 100, message = "La contraseña debe tener al menos 8 caracteres")
    String clave
) {
}

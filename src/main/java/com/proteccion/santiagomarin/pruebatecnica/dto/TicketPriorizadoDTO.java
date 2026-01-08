package com.proteccion.santiagomarin.pruebatecnica.dto;

import com.proteccion.santiagomarin.pruebatecnica.entities.utils.TipoSolicitud;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketPriorizadoDTO {
    private String id;
    private TipoSolicitud tipo;
    private Integer prioridadManual;
    private LocalDateTime fechaCreacion;
    private String usuarioNombreCompleto;
    private int prioridadCalculada;
}

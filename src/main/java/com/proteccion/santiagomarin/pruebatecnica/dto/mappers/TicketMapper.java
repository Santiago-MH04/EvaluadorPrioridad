package com.proteccion.santiagomarin.pruebatecnica.dto.mappers;

import com.proteccion.santiagomarin.pruebatecnica.dto.NuevaSolicitudDTO;
import com.proteccion.santiagomarin.pruebatecnica.dto.TicketPriorizadoDTO;
import com.proteccion.santiagomarin.pruebatecnica.entities.Solicitud;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    @Mapping(
        target = "usuarioNombreCompleto",
        expression = "java(solicitud.getUsuario().getNombre() + \" \" + solicitud.getUsuario().getApellido())"
    )
    @Mapping(target = "prioridadCalculada", ignore = true)
    TicketPriorizadoDTO toDTO(Solicitud solicitud);

    NuevaSolicitudDTO toNuevaDTO(Solicitud solicitud);
    Solicitud toEntity(NuevaSolicitudDTO dto);
}

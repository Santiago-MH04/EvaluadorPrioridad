package com.proteccion.santiagomarin.pruebatecnica.services.abstractions;

import com.proteccion.santiagomarin.pruebatecnica.entities.Solicitud;

import java.util.List;

public interface SolicitudService {
    List<Solicitud> findAll();
    Solicitud save(Solicitud solicitud);
}

package com.proteccion.santiagomarin.pruebatecnica.services.abstractions;

import com.proteccion.santiagomarin.pruebatecnica.entities.Solicitud;

public interface PrioridadCalculatorService {
    public int calcularPrioridad(Solicitud solicitud);
}

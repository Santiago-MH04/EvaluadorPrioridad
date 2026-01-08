package com.proteccion.santiagomarin.pruebatecnica.services;

import com.proteccion.santiagomarin.pruebatecnica.entities.Solicitud;

public interface PrioridadadCalculatorService {
    public int calcularPrioridad(Solicitud solicitud);
}

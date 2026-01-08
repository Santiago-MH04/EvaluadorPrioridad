package com.proteccion.santiagomarin.pruebatecnica.services;

import com.proteccion.santiagomarin.pruebatecnica.entities.Solicitud;
import com.proteccion.santiagomarin.pruebatecnica.entities.utils.TipoSolicitud;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class PrioridadCalculatorServiceImpl implements PrioridadadCalculatorService{
    @Override
    public int calcularPrioridad(Solicitud solicitud) {
        int pesoTipo = getPesoTipo(solicitud.getTipo());    // 1000, 3000 o 5000
        long diffSegundos = LocalDateTime.now()
            .toEpochSecond(ZoneOffset.UTC) -
            solicitud.getFechaCreacion().toEpochSecond(ZoneOffset.UTC);
        int horasTranscurridas = (int) (diffSegundos / 3600);
        int puntosAntiguedad = horasTranscurridas * 10;             // 10 puntos/h
        int puntosManual = (solicitud.getPrioridadManual() != null ?
            solicitud.getPrioridadManual() * 100 : 100); // default 1 * 100

        return pesoTipo + puntosAntiguedad + puntosManual;
    }

    private static int getPesoTipo(TipoSolicitud tipo) {
        return switch (tipo) {
            case INCIDENTE -> 5000;
            case REQUERIMIENTO -> 3000;
            case CONSULTA -> 1000;
        };
    }
}

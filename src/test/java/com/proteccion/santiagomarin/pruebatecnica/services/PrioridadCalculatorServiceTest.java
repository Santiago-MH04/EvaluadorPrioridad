package com.proteccion.santiagomarin.pruebatecnica.services;


import com.proteccion.santiagomarin.pruebatecnica.entities.Solicitud;
import com.proteccion.santiagomarin.pruebatecnica.entities.utils.TipoSolicitud;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrioridadCalculatorServiceImplTest {

    private final PrioridadCalculatorServiceImpl service = new PrioridadCalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("prioridadesDataProvider")
    void calcularPrioridad_retornaCorrecto(TipoSolicitud tipo, int horas, int manual, int esperado) {
        Solicitud solicitud = new Solicitud();
            solicitud.setTipo(tipo);
            solicitud.setFechaCreacion(LocalDateTime.now().minusHours(horas));
            solicitud.setPrioridadManual(manual);

        int resultado = service.calcularPrioridad(solicitud);

        assertEquals(esperado, resultado);
    }

    static Stream<Arguments> prioridadesDataProvider() {
        return Stream.of(
                // INCIDENTE domina siempre
                Arguments.of(TipoSolicitud.INCIDENTE, 0, 5, 5500),
                Arguments.of(TipoSolicitud.INCIDENTE, 3, 3, 5330),
                Arguments.of(TipoSolicitud.INCIDENTE, 10, 1, 5200),

                // REQUERIMIENTO medio
                Arguments.of(TipoSolicitud.REQUERIMIENTO, 5, 5, 3550),

                // CONSULTA siempre bajo
                Arguments.of(TipoSolicitud.CONSULTA, 24, 5, 1740)
        );
    }
}
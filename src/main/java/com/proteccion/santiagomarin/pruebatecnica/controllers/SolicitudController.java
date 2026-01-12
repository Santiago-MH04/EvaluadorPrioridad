package com.proteccion.santiagomarin.pruebatecnica.controllers;

import com.proteccion.santiagomarin.pruebatecnica.dto.dtoRequests.SolicitudDTO;
import com.proteccion.santiagomarin.pruebatecnica.dto.dtoRequests.TicketPriorizadoDTO;
import com.proteccion.santiagomarin.pruebatecnica.dto.mappers.SolicitudMapper;
import com.proteccion.santiagomarin.pruebatecnica.dto.mappers.TicketMapper;
import com.proteccion.santiagomarin.pruebatecnica.entities.Solicitud;
import com.proteccion.santiagomarin.pruebatecnica.services.abstractions.PrioridadCalculatorService;
import com.proteccion.santiagomarin.pruebatecnica.services.abstractions.SolicitudService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class SolicitudController {
    private final SolicitudService solicitudService;
    private final PrioridadCalculatorService prioridadCalculatorService;
    private final TicketMapper ticketMapper;
    private final SolicitudMapper solicitudMapper;

    @GetMapping("/prioritised")
    public ResponseEntity<List<TicketPriorizadoDTO>> getTicketsPriorizados() {
        return ResponseEntity.ok(
            this.solicitudService.findAll().stream()
                .map(solicitud -> {
                    TicketPriorizadoDTO dto = ticketMapper.toDTO(solicitud);
                        dto.setPrioridadCalculada(this.prioridadCalculatorService.calcularPrioridad(solicitud));
                    return dto;
                })
            .sorted(Comparator.comparingInt(TicketPriorizadoDTO::getPrioridadCalculada).reversed())
            .toList()
        );
    }

    @PostMapping("/crear")
    public ResponseEntity<TicketPriorizadoDTO> crearSolicitud(
        @Valid @RequestBody SolicitudDTO nuevaSolicitud
    ) {
        Solicitud saved = this.solicitudService.save(
            this.solicitudMapper.toEntity(nuevaSolicitud)
        );

        int prioridad = this.prioridadCalculatorService.calcularPrioridad(saved);
        TicketPriorizadoDTO response = this.ticketMapper.toDTO(saved);
            response.setPrioridadCalculada(prioridad);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

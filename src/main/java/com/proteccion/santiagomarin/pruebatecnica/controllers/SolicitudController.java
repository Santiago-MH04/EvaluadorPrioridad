package com.proteccion.santiagomarin.pruebatecnica.controllers;

import com.proteccion.santiagomarin.pruebatecnica.dto.TicketPriorizadoDTO;
import com.proteccion.santiagomarin.pruebatecnica.dto.mappers.TicketMapper;
import com.proteccion.santiagomarin.pruebatecnica.repositories.SolicitudRepository;
import com.proteccion.santiagomarin.pruebatecnica.services.PrioridadCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class SolicitudController {
    private final SolicitudRepository repoSolicitud;
    private final PrioridadCalculatorService prioridadCalculatorService;
    private final TicketMapper ticketMapper;

    @GetMapping("/prioritised")
    public ResponseEntity<List<TicketPriorizadoDTO>> getTicketsPriorizados() {
        return ResponseEntity.ok(
            this.repoSolicitud.findAll().stream()
                .map(solicitud -> {
                    TicketPriorizadoDTO dto = ticketMapper.toDTO(solicitud);
                    dto.setPrioridadCalculada(this.prioridadCalculatorService.calcularPrioridad(solicitud));
                    return dto;
                })
            .sorted(Comparator.comparingInt(TicketPriorizadoDTO::getPrioridadCalculada).reversed())
            .toList()
        );
    }
}

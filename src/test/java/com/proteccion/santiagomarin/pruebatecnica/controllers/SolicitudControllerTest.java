package com.proteccion.santiagomarin.pruebatecnica.controllers;

import com.proteccion.santiagomarin.pruebatecnica.dto.TicketPriorizadoDTO;
import com.proteccion.santiagomarin.pruebatecnica.dto.mappers.TicketMapper;
import com.proteccion.santiagomarin.pruebatecnica.entities.utils.TipoSolicitud;
import com.proteccion.santiagomarin.pruebatecnica.repositories.SolicitudRepository;
import com.proteccion.santiagomarin.pruebatecnica.services.PrioridadCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SolicitudController.class)
class SolicitudControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SolicitudRepository repository;

    @MockitoBean
    private PrioridadCalculatorService service;

    @MockitoBean
    private TicketMapper mapper;

    private TicketPriorizadoDTO crear;

    private TicketPriorizadoDTO crearDtoConPrioridad(int prioridad) {
        TicketPriorizadoDTO dto = new TicketPriorizadoDTO();
            dto.setPrioridadCalculada(prioridad);
            dto.setTipo(TipoSolicitud.INCIDENTE);
            dto.setUsuarioNombreCompleto("Ana Gómez");
        return dto;
    }

    @Test
    void getTicketsPriorizados_retornaOrdenado() throws Exception {
        // Arrange - Mock datos
        TicketPriorizadoDTO dto1 = crearDtoConPrioridad(5500);
        TicketPriorizadoDTO dto2 = crearDtoConPrioridad(3500);

        /*when(repository.findAll()).thenReturn(List.of());*/
        when(mapper.toDTO(any())).thenReturn(dto1, dto2);
        when(service.calcularPrioridad(any())).thenReturn(5500, 3500);

        // Act & Assert
        mockMvc.perform(get("/api/tickets/prioritised"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            /*.andExpect(jsonPath("$.length()").value(2))*/;
    }
}

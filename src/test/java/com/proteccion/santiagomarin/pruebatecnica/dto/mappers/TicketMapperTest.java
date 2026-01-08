package com.proteccion.santiagomarin.pruebatecnica.dto.mappers;

import com.proteccion.santiagomarin.pruebatecnica.dto.TicketPriorizadoDTO;
import com.proteccion.santiagomarin.pruebatecnica.entities.Solicitud;
import com.proteccion.santiagomarin.pruebatecnica.entities.Usuario;
import com.proteccion.santiagomarin.pruebatecnica.entities.utils.TipoSolicitud;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TicketMapperTest {

    @Autowired
    private TicketMapper ticketMapper;

    private Solicitud solicitud;

    @BeforeEach
    void setUp() {
        solicitud = new Solicitud();
        Usuario usuario = new Usuario();
            usuario.setNombre("Ana");
            usuario.setApellido("Gómez");
        solicitud.setUsuario(usuario);
        solicitud.setTipo(TipoSolicitud.INCIDENTE);
    }

    @Test
    void toDTO_mapeaCorrectamente() {
        TicketPriorizadoDTO dto = ticketMapper.toDTO(solicitud);

        assertEquals("Ana Gómez", dto.getUsuarioNombreCompleto());
        assertEquals(TipoSolicitud.INCIDENTE, dto.getTipo());
    }
}

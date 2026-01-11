package com.proteccion.santiagomarin.pruebatecnica.services.implementations;

import com.proteccion.santiagomarin.pruebatecnica.entities.Solicitud;
import com.proteccion.santiagomarin.pruebatecnica.repositories.SolicitudRepository;
import com.proteccion.santiagomarin.pruebatecnica.services.abstractions.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {
    private final SolicitudRepository repoSolicitud;

    @Override
    @Transactional(readOnly = true)
    public List<Solicitud> findAll() {
        return this.repoSolicitud.findAll();
    }

    @Override
    @Transactional()
    public Solicitud save(Solicitud solicitud) {
        return this.repoSolicitud.save(solicitud);
    }
}

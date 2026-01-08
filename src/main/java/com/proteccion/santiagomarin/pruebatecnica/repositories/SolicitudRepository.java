package com.proteccion.santiagomarin.pruebatecnica.repositories;

import com.proteccion.santiagomarin.pruebatecnica.entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, String> {

}

package com.proteccion.santiagomarin.pruebatecnica.repositories;

import com.proteccion.santiagomarin.pruebatecnica.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

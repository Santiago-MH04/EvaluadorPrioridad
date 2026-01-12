package com.proteccion.santiagomarin.pruebatecnica.repositories;

import com.proteccion.santiagomarin.pruebatecnica.entities.Role;
import com.proteccion.santiagomarin.pruebatecnica.entities.utils.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNombre(RoleName roleName);
}

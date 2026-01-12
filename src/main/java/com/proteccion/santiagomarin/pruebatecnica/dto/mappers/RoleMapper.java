package com.proteccion.santiagomarin.pruebatecnica.dto.mappers;

import com.proteccion.santiagomarin.pruebatecnica.dto.RoleDTO;
import com.proteccion.santiagomarin.pruebatecnica.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(source = "nombre", target = "nombre")
    RoleDTO toDTO(Role role);

    @Mapping(source = "nombre", target = "nombre")
    Role toEntity(RoleDTO roleDTO);
}


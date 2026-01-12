package com.proteccion.santiagomarin.pruebatecnica.dto.mappers;

import com.proteccion.santiagomarin.pruebatecnica.dto.dtoRequests.UsuarioDTO;
import com.proteccion.santiagomarin.pruebatecnica.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    Usuario toEntity(UsuarioDTO dto);

    UsuarioDTO toDTO(Usuario entity);
}

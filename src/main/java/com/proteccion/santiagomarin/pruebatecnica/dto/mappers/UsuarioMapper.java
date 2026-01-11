package com.proteccion.santiagomarin.pruebatecnica.dto.mappers;

import com.proteccion.santiagomarin.pruebatecnica.dto.UsuarioDTO;
import com.proteccion.santiagomarin.pruebatecnica.entities.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);

    UsuarioDTO toDTO(Usuario entity);
}

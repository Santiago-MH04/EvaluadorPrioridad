package com.proteccion.santiagomarin.pruebatecnica.services.implementations;

import com.proteccion.santiagomarin.pruebatecnica.entities.Usuario;
import com.proteccion.santiagomarin.pruebatecnica.repositories.UsuarioRepository;
import com.proteccion.santiagomarin.pruebatecnica.services.abstractions.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repoUsuario;

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return this.repoUsuario.save(usuario);
    }
}

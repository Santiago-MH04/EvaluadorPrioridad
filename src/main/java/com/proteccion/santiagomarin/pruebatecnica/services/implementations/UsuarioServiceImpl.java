package com.proteccion.santiagomarin.pruebatecnica.services.implementations;

import com.proteccion.santiagomarin.pruebatecnica.entities.Role;
import com.proteccion.santiagomarin.pruebatecnica.entities.Usuario;
import com.proteccion.santiagomarin.pruebatecnica.entities.utils.RoleName;
import com.proteccion.santiagomarin.pruebatecnica.repositories.RoleRepository;
import com.proteccion.santiagomarin.pruebatecnica.repositories.UsuarioRepository;
import com.proteccion.santiagomarin.pruebatecnica.services.abstractions.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repoUsuario;
    private final RoleRepository repoRole;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        if (usuario.getRoles() == null || usuario.getRoles().isEmpty()) {
            Role defaultRole = this.repoRole.findByNombre(RoleName.ROLE_USER)
                .orElseThrow();
            usuario.setRoles(Set.of(defaultRole));
        }
        usuario.setClave(this.passwordEncoder.encode(usuario.getClave()));
        return this.repoUsuario.save(usuario);
    }
}

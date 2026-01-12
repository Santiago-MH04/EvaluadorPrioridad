package com.proteccion.santiagomarin.pruebatecnica.services.implementations;

import com.proteccion.santiagomarin.pruebatecnica.entities.Usuario;
import com.proteccion.santiagomarin.pruebatecnica.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository repoUsuario;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuarioCargado = this.repoUsuario.findByCorreo(username)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("Usuario %s no encontrado", username)));

        List<GrantedAuthority> authorities = usuarioCargado.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getNombre().name()))
            .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
            usuarioCargado.getCorreo(),
            usuarioCargado.getClave(),
            authorities
        );
    }
}

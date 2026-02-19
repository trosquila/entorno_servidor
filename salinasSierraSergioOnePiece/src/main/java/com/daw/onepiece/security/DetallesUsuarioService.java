package com.daw.onepiece.security;

import com.daw.onepiece.entities.RoleEntity;
import com.daw.onepiece.entities.UserEntity;
import com.daw.onepiece.repositorios.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DetallesUsuarioService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. Buscamos al usuario en la base de datos
        UserEntity user = userRepository.findByUserName(username);

        // 2. Validación: Si no existe, lanzamos la excepción
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        // 3. Convertimos tus RoleEntity en GrantedAuthority de Spring Security
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (RoleEntity role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getUserRole()));
        }

        // 4. Retornamos el objeto User de Spring Security (el que entiende el framework)
        return new User(
                user.getUserName(),
                user.getUserPasswd(),
                authorities
        );
    }
}
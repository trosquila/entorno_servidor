package com.daw.onepiece.controladores.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.onepiece.dtos.JwtDTO;
import com.daw.onepiece.dtos.LoginDTO;
import com.daw.onepiece.security.JwtTokenProvider;

@RestController
@RequestMapping("/v1")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    /*
     * POST /api/auth/login con body: { "username": "Oscar", "password": "1234" }
     */
    @PostMapping("/login")
    public ResponseEntity authenticateUser(@RequestBody LoginDTO loginRequest) {

        // PASO 1: Autenticar al usuario con username y password
        // Si las credenciales son incorrectas, esto lanza una BadCredentialsException
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsuario(),
                loginRequest.getPasswd()
            )
        );

        // PASO 2: Establecer la autenticación en el contexto de seguridad
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // PASO 3: Generar el token JWT
        String jwt = tokenProvider.generateToken(authentication);

        // PASO 4: Otener los roles del usuario autenticado
        List roles = new ArrayList();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            roles.add(authority.getAuthority());
        }

        // PASO 5: Devolver la respuesta con el token y datos del usuario
        return ResponseEntity.ok(new JwtDTO(
            jwt,                        // El token JWT
            loginRequest.getUsuario(),  // El username
            roles                       // Los roles
        ));
    }
}

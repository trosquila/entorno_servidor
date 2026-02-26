package com.daw.onepiece.security;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private DetallesUsuarioService userDetailsService;
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	@Bean
	@Order(1)
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/**") // Aplica a todas las rutas que no sean APIs
        .securityMatcher(request -> {
            String uri = request.getRequestURI();
            return !uri.startsWith("/v1"); // Excluye /v1/* 
        })// Excluye /v1/*
				// 1. Deshabilitar CSRF (común en APIs o si manejas tus propios tokens)
				.csrf(csrf -> csrf.disable())

				// 2. Autorización de peticiones
				.authorizeHttpRequests(auth -> auth
						// URLs públicas
						.requestMatchers("/", "/login", "/accesoDenegado", "/css/**").permitAll()

						// URLs que requieren estar logueado (cualquier rol)
						.requestMatchers("/home/**").authenticated()

						// Roles específicos (Asegúrate de que coincidan con tu DB)
						.requestMatchers("/piratas/**").hasAnyAuthority("almirante", "vicealmirante")
						.requestMatchers("/recompensas/**").hasAnyAuthority("almirante", "capitan")
						.requestMatchers("/tripulaciones/**").hasAnyAuthority("almirante", "vicealmirante")

						// El resto de la aplicación es solo para el director
						.anyRequest().hasAuthority("almirante"))

				// 3. Configuración del Login
				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home", true).permitAll())

				// 4. Configuración del Logout
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll())

				// 5. Manejo de excepciones (403 Prohibido)
				.exceptionHandling(exception -> exception.accessDeniedPage("/accesoDenegado"));

		return http.build();
	}
	@Bean
	@Order(2)
	public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
	    http
	        // Aplica a ambas versiones
	        .securityMatcher("/v1/**")
	        .csrf(csrf -> csrf.disable())
	        
	        // SESIONES: Política STATELESS (sin sesiones en servidor)
	        .sessionManagement(session -> 
	            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        )
	        
	        .authorizeHttpRequests(auth -> auth
	            // Endpoints públicos
	            .requestMatchers("/v1/login/**").permitAll()
	            .requestMatchers("/error").permitAll()
	            
	            // Endpoints protegidos por roles
	            .requestMatchers("/v1/piratas/**")
	                .hasAnyAuthority("almirante","vicealmirante")
	            .requestMatchers("/v1/recompensas/**")
	                .hasAnyAuthority("almirante", "capitan")
	            .requestMatchers("/v1/tripulaciones/**")
	                .hasAnyAuthority("almirante", "vicealmirante")
	            
	            // Cualquier otra petición API requiere autenticación
	            .anyRequest().authenticated()
	        )
	        
	        // MANEJO DE ERRORES
	        .exceptionHandling(exceptions -> exceptions
	            .authenticationEntryPoint((request, response, authException) -> {
	                response.setContentType("application/json;charset=UTF-8");
	                response.setStatus(HttpStatus.UNAUTHORIZED.value());
	                response.getWriter().write(
	                    "{\"timestamp\":\"" + LocalDateTime.now() + "\"," +
	                    "\"status\":401," +
	                    "\"error\":\"No autorizado\"," +
	                    "\"message\":\"Token no válido o no proporcionado\"}"
	                );
	            })
	            .accessDeniedHandler((request, response, accessDeniedException) -> {
	                response.setContentType("application/json;charset=UTF-8");
	                response.setStatus(HttpStatus.FORBIDDEN.value());
	                response.getWriter().write(
	                    "{\"timestamp\":\"" + LocalDateTime.now() + "\"," +
	                    "\"status\":403," +
	                    "\"error\":\"Acceso denegado\"," +
	                    "\"message\":\"No tienes permisos para acceder a este recurso\"}"
	                );
	            })
	        )
	        
	        // Añadimos nuestro filtro ANTES del filtro de autenticación estándar
	        // Esto significa que nuestro filtro se ejecutará primero
	        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

	    return http.build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

}
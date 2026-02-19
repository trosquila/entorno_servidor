package com.daw.onepiece.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private DetallesUsuarioService userDetailsService;

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

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Deshabilitar CSRF (común en APIs o si manejas tus propios tokens)
            .csrf(csrf -> csrf.disable()) 
            
            // 2. Autorización de peticiones
            .authorizeHttpRequests(auth -> auth
                // URLs públicas
                .requestMatchers("/", "/login", "/accesoDenegado", "/css/**", "/js/**").permitAll()
                
                // URLs que requieren estar logueado (cualquier rol)
                .requestMatchers("/home/**").authenticated()
                
                // Roles específicos (Asegúrate de que coincidan con tu DB)
                .requestMatchers("/notas/**").hasAnyAuthority("director", "profesor")
                .requestMatchers("/faltas/**").hasAnyAuthority("director", "profesor")
                .requestMatchers("/matriculaciones/**").hasAnyAuthority("director", "secretario")
                
                // El resto de la aplicación es solo para el director
                .anyRequest().hasAuthority("director")
            )
            
            // 3. Configuración del Login
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .permitAll()
            )
            
            // 4. Configuración del Logout
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            )
            
            // 5. Manejo de excepciones (403 Prohibido)
            .exceptionHandling(exception -> exception
                .accessDeniedPage("/accesoDenegado")
            );

        return http.build();
    }
}
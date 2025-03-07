package com.example.employeeManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for simplicity in development
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll()  // Public endpoints
                        .requestMatchers("/api/**").permitAll() // Other public endpoints
                        .requestMatchers("/ws/**").permitAll()  // WebSocket endpoints
                        // For development, you can temporarily allow all requests
                        .anyRequest().permitAll()  // Change to .authenticated() when you implement authentication
                );

        return http.build();
    }
}
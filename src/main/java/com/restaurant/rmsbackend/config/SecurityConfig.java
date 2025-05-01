package com.restaurant.rmsbackend.config;

import com.restaurant.rmsbackend.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration public class SecurityConfig{

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();
        UserDetails chef = User.withUsername("chef1")
                .password("chef123")
                .roles("CHEF")
                .build();
        UserDetails cashier = User.withUsername("cashier1")
                .password("cash123")
                .roles("CASHIER")
                .build();
        return new InMemoryUserDetailsManager(admin, chef, cashier);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/menu/**").hasRole("ADMIN")
                        .requestMatchers("/api/orders/**").hasAnyRole("ADMIN", "CASHIER")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()) // For simple testing via Postman
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Only for demo (not secure)
    }








}
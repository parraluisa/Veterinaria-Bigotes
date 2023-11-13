package com.bigotes.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthEntryPoint jwtAuthEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .sessionManagement(customizer -> customizer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(AntPathRequestMatcher
                                .antMatcher("/h2/**")).permitAll()
                        .requestMatchers(
                                AntPathRequestMatcher
                                        .antMatcher("/login/**")).permitAll()
                        /*
                        .requestMatchers(
                                AntPathRequestMatcher.antMatcher("/pet/**")).hasAnyRole("ADMIN", "VET", "OWNER")
                        .requestMatchers(
                                AntPathRequestMatcher.antMatcher("/vet/**")).hasRole("ADMIN")
                        .requestMatchers(
                                AntPathRequestMatcher.antMatcher("/admin/**")).hasRole("ADMIN")
                        .requestMatchers(
                                AntPathRequestMatcher.antMatcher("/drug/**")).hasAnyRole("ADMIN", "VET")
                        .requestMatchers(
                                AntPathRequestMatcher.antMatcher("/treatment/**")).hasAnyRole("ADMIN", "VET")
                        .requestMatchers(
                                AntPathRequestMatcher.antMatcher("/owner/**")).hasAnyRole("ADMIN", "OWNER", "VET")
                         */
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthEntryPoint));

        http.addFilterBefore(jwtAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * Permite autenticar a los usuarios con usuario y contrasena
     * Al autenticar devuelve un onjeto Authentication que posteriormente se puede
     * usar a traves de SecurityContextHolder
     * para obtener el usuario autenticado
     */
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }

}

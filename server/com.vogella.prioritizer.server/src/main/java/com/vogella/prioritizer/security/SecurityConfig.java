package com.vogella.prioritizer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories
            .createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
        return http
            .csrf()
            .disable()
            .formLogin()
            .disable()
            .httpBasic()
            .disable()
            .authorizeExchange()
            .anyExchange()
            .permitAll()
            .and()
            .build();
//        return http
//        		.csrf()
//        		.disable()
//        		.formLogin()
//        		.disable()
//        		.httpBasic()
//        		.disable()
//        		.authorizeExchange()
//        		.pathMatchers(HttpMethod.OPTIONS)
//        		.permitAll()
//        		.pathMatchers("/bugzilla/mostDiscussedBugsOfTheMonth")
//        		.permitAll()
//        		.anyExchange()
//        		.authenticated()
//        		.and()
//        		.build();
    }
}

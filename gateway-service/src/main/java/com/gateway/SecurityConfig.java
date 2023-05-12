package com.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {


	@Bean
	SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
		http
			.authorizeExchange()
				.pathMatchers("/actuator/prometheus").permitAll()
			.anyExchange()
			.authenticated().and()
			.oauth2ResourceServer().jwt();

		return http.build();
	}

}
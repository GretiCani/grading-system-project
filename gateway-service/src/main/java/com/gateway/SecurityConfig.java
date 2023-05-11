package com.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Value("${server.port}")
	private String test;

	@Bean
	SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
		http
			.authorizeExchange()
				.pathMatchers("/actuator/health/**").permitAll()
				.pathMatchers(HttpMethod.GET,"/webjars/**").permitAll()
				.pathMatchers(HttpMethod.GET,"/swagger-ui.html").permitAll()
				.pathMatchers(HttpMethod.GET,"/swagger-resources/**").permitAll()
				.pathMatchers(HttpMethod.GET,"/v3/api-docs/**").permitAll()
				.pathMatchers(HttpMethod.GET,"/professor-service/v3/api-docs/**").permitAll()
				.pathMatchers(HttpMethod.GET,"/course-service/v3/api-docs/**").permitAll()
				.pathMatchers(HttpMethod.GET,"/student-service/v3/api-docs/**").permitAll()
				.pathMatchers(HttpMethod.GET,"/evaluation-service/v3/api-docs/**").permitAll()
				.pathMatchers(HttpMethod.GET,"/notification-service/v3/api-docs/**").permitAll()
			.anyExchange()
			.authenticated().and().oauth2ResourceServer((resourceServer) -> resourceServer
				.jwt(withDefaults())
		);

		return http.build();
	}

	@Bean
	public CorsWebFilter corsWebFilter() {
		final CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Collections.singletonList("http://auth-server:9000"));
		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "HEAD", "PUT"));
		corsConfig.addAllowedHeader("Access-Control-Allow-Origin");

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}

}
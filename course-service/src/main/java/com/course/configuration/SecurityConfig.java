package com.course.configuration;

import org.springdoc.core.AbstractSwaggerUiConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/actuator/prometheus").permitAll()
				.antMatchers("/actuator/health/**").permitAll()
				.antMatchers("/webjars/**").permitAll()
				.antMatchers("/swagger-ui.html").permitAll()
				.antMatchers("/swagger-ui/**").permitAll()
				.antMatchers("/course-service/v3/api-docs/**").permitAll()
				.antMatchers("/swagger-resources/**").permitAll()
				.antMatchers("/v3/api-docs/**").permitAll()
				.anyRequest().authenticated()
				.and().oauth2ResourceServer()
				.jwt();
		return http.build();
	}

	@Bean
	public JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
		grantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
		grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
		return jwtAuthenticationConverter;
	}

}
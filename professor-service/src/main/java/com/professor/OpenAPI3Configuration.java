package com.professor;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(servers = { @Server(url = "${swagger.server.uri}")}, info = @Info(title = "Professor Service APIs",
        description = "This lists all the Professor Service API Calls. The Calls are OAuth2 secured, "
  + "so please use your Bearer token to test them out.",
version = "v1.0"),security ={@SecurityRequirement(name = "bearerToken")})
@SecurityScheme(name = "bearerToken",scheme = "bearer",bearerFormat = "JWT", type = SecuritySchemeType.HTTP)
@Configuration
public class OpenAPI3Configuration {



}
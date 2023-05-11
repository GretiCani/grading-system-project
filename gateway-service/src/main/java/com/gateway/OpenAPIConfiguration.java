package com.gateway;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OpenAPIConfiguration {

    @Autowired
    RouteDefinitionLocator locator;

 @Bean
 public OpenAPI gatewayOpenApi() {
     return new OpenAPI().info(new Info().title("Grading System Application Microservices APIs ")
             .description("Documentation for all the Microservices in Grading System Application")
             .version("v1.0.0"))
             .components(new Components().addSecuritySchemes("Authorization",new SecurityScheme()
                     .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }

}
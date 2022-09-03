package com.auth.server.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "registered-client")
public class RegisteredClientConfig {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String issuerUri;
    private String tokenParam;
    private String roleClaim;
}

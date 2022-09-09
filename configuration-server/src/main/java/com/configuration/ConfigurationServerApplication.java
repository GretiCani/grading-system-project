package com.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
@RestController
public class ConfigurationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationServerApplication.class, args);
    }



}

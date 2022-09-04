package com.professor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Value("${courseService.schema}")
    private String schema;
    @Value("${courseService.host}")
    private String host;
    @Value("${courseService.port}")
    private Integer port;
    @Value("${courseService.path}")
    private String path;

    private final WebClient webClient;

    @GetMapping("/ok")
    public String ok(){
        return "professor-service ok"+webClient.get()
                .uri(uriBuilder -> uriBuilder.scheme(schema)
                        .host(host)
                        .port(port)
                        .path(path)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}

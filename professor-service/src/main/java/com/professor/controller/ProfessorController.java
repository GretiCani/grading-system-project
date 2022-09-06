package com.professor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.security.RolesAllowed;

@RequiredArgsConstructor
@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Value("${resource.courseService.baseUrl}")
    private String courseUrl;


    private final WebClient webClient;

    @PreAuthorize("hasAuthority('ROLE_INSTRUCTOR')")
    @GetMapping("/ok")
    public String ok(){
        return "professor-service ok"+webClient.get().uri(courseUrl+"/list")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}

package com.professor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessorController {

    @GetMapping("/ok")
    public String ok(){
        return "professor-service ok";
    }
}

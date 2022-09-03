package com.evaluation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvaluationController {

    @GetMapping("/ok")
    public String ok(){
        return "evaluation-service ok";
    }
}

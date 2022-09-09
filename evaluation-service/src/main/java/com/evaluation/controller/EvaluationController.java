package com.evaluation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@Slf4j
@RestController
public class EvaluationController {

    @GetMapping("/ok")
    public String ok(){
        IntStream.range(0,10).forEach(index -> {
            log.info("evaluation-service  info log "+1);
        });
        return "evaluation-service ok";
    }
}

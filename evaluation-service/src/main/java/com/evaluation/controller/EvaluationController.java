package com.evaluation.controller;

import com.evaluation.model.Evaluation;
import com.evaluation.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@Slf4j
@RequiredArgsConstructor
@RestController
public class EvaluationController {

    private final EvaluationService evaluationService;

    @GetMapping("/ok")
    public String ok(){
        return "evaluation-service ok";
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addGrade(@RequestBody Evaluation evaluation){
        evaluationService.sendNotification(evaluation);
        return ResponseEntity.ok().build();
    }
}

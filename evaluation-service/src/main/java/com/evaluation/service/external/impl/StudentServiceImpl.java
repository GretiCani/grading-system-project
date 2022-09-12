package com.evaluation.service.external.impl;

import com.evaluation.model.Evaluation;
import com.evaluation.service.external.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;



@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    @Value("${resource.studentService.baseUrl}")
    private String studentServiceUrl;

    private final WebClient webClient;


    @Override
    public Long addGrade(Evaluation evaluation) {

         return webClient.post()
                .uri(studentServiceUrl+"/add-grade")
                .body(Mono.just(evaluation),Evaluation.class)
                .retrieve()
                .bodyToMono(Long.class)
                .block();
    }


}

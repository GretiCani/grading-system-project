package com.evaluation.service.impl;

import com.evaluation.model.Evaluation;
import com.evaluation.model.Notification;
import com.evaluation.service.EvaluationService;
import com.evaluation.service.external.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Value("${kafkaTopics.notification}")
    private String kafkaTopic;

    private final StudentService studentService;

    private final KafkaTemplate<Object,Object> kafkaTemplate;

    @Override
    public void sendNotification(Evaluation evaluation) {
        Long updateResult = studentService.addGrade(evaluation);
        if(Objects.isNull(updateResult))
            return;

        Notification notification = Notification.builder()
                .email(evaluation.getStudentEmail())
                .subject("Grade Notification")
                .message("Dear student!\n your grade for assessment grade is generated")
                .build();
        kafkaTemplate.send(kafkaTopic, notification);

    }
}

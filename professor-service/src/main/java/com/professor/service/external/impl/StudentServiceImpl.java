package com.professor.service.external.impl;

import com.professor.model.AssessmentItem;
import com.professor.model.EnrolledCourse;
import com.professor.model.Grade;
import com.professor.service.external.StudentService;
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
    public EnrolledCourse addCourseToStudent(EnrolledCourse enrolledCourse) {

        return webClient.post().uri(studentServiceUrl+"/enrolled-course")
                 .body(Mono.just(enrolledCourse ),EnrolledCourse.class)
                 .retrieve()
                 .bodyToMono(EnrolledCourse.class)
                 .block();
    }

    @Override
    public EnrolledCourse addAssessmentToStudent(AssessmentItem a) {
        return webClient.post()
                .uri(studentServiceUrl+"/{studentId}/add-assessment/{courseId}",a.getCourseId(),a.getStudentId())
                .body(Mono.just(a.getGrade()), Grade.class)
                .retrieve()
                .bodyToMono(EnrolledCourse.class)
                .block();
    }
}

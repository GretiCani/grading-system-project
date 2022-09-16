package com.professor.service.external.impl;

import com.professor.model.Course;
import com.professor.service.external.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    @Value("${resource.courseService.baseUrl}")
    private String courseServiceUrl;

    private final WebClient webClient;

    @Override
    public List<Course> getCourses(String instructorId) {
        return webClient.get()
                .uri(courseServiceUrl+"/all/{instructorId}",instructorId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Course>>(){})
                .block();
    }
}

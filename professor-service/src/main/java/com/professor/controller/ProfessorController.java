package com.professor.controller;

import com.professor.model.EnrolledCourse;
import com.professor.service.external.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/professor")
public class ProfessorController {


    private final StudentService studentService;

    @GetMapping("/ok")
    public String ok(){
        IntStream.range(0,10).forEach(index -> {
            log.info("professor-service  info log "+1);
        });
        return "professor-service ok";
    }

    @PreAuthorize("hasAuthority('ROLE_INSTRUCTOR')")
    @PostMapping("/add-student")
    public ResponseEntity<EnrolledCourse> addCourseToStudent(@RequestBody EnrolledCourse course){

        return ResponseEntity.ok(studentService.addCourseToStudent(course));
    }
}

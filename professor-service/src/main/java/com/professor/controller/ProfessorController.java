package com.professor.controller;

import com.professor.model.EnrolledCourse;
import com.professor.service.external.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/professor")
public class ProfessorController {


    private final StudentService studentService;

    @GetMapping("/ok")
    public String ok(){
        return "notification-service ok";
    }

    @PreAuthorize("hasAuthority('ROLE_INSTRUCTOR')")
    @PostMapping("/add-student")
    public ResponseEntity<EnrolledCourse> addCourseToStudent(@RequestBody EnrolledCourse course){
        return ResponseEntity.ok(studentService.addCourseToStudent(course));
    }
}

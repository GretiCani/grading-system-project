package com.student.controller;

import com.student.entity.EnrolledCourse;
import com.student.service.EnrolledCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    private final EnrolledCourseService enrolledCourseService;

    @GetMapping("/ok")
    public String ok(){
        return "student-service-ok";
    }

    @PostMapping("/enrolled-course")
    public ResponseEntity<EnrolledCourse> addEnrolledCourse(@RequestBody EnrolledCourse enrolledCourse){
        return ResponseEntity.ok(enrolledCourseService.add(enrolledCourse));
    }
}

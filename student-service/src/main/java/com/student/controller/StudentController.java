package com.student.controller;

import com.student.entity.EnrolledCourse;
import com.student.entity.Grade;
import com.student.service.EnrolledCourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    private final EnrolledCourseService enrolledCourseService;

    @GetMapping("/ok")
    public String ok(){
        IntStream.range(0,10).forEach(index -> {
            log.info("student-service  info log "+1);
        });
        return "student-service-ok";
    }

    @PostMapping("/enrolled-course")
    public ResponseEntity<EnrolledCourse> addEnrolledCourse(@RequestBody EnrolledCourse enrolledCourse){
        return ResponseEntity.ok(enrolledCourseService.add(enrolledCourse));
    }

    @PostMapping("/add-assessment/{courseId}/{studentId}")
    public ResponseEntity<EnrolledCourse> addAssessment(@PathVariable String courseId, @PathVariable String studentId, @RequestBody Grade grade){
        return ResponseEntity.ok(enrolledCourseService.addAssessment(courseId,studentId,grade));
    }
}

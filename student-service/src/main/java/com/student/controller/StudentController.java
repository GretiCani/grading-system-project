package com.student.controller;

import com.student.entity.EnrolledCourse;
import com.student.entity.Grade;
import com.student.model.Evaluation;
import com.student.service.EnrolledCourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
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

    @GetMapping("/enrolled-course/{courseId}")
    public ResponseEntity<List<EnrolledCourse>> getEnrolledCourseByCourseId(@PathVariable String courseId){
        return ResponseEntity.ok(enrolledCourseService.findByCourseId(courseId));
    }

    @GetMapping("/{studentId}/enrolled-course/{courseId}")
    public ResponseEntity<EnrolledCourse> findByCourseIdStudentId(@PathVariable String courseId, @PathVariable String studentId){
        return ResponseEntity.ok(enrolledCourseService.findByCourseIdAndStudentId(courseId,studentId));
    }

    @GetMapping("/{studentId}/enrolled-course")
    public ResponseEntity<List<EnrolledCourse>> findByCourseIdStudentId(@PathVariable String studentId){
        return ResponseEntity.ok(enrolledCourseService.findCoursesByStudentId(studentId));
    }

    @PostMapping("/{studentId}/add-assessment/{courseId}")
    public ResponseEntity<EnrolledCourse> addAssessment(@PathVariable String courseId, @PathVariable String studentId, @RequestBody Grade grade){
        return ResponseEntity.ok(enrolledCourseService.addAssessment(courseId,studentId,grade));
    }

    @PostMapping("/add-grade")
    public ResponseEntity<Long>addGrade(@RequestBody Evaluation e){
        return ResponseEntity.ok(enrolledCourseService.updateGrades(e.getCourseId(),e.getStudentId(),e.getAssessmentId(),e.getGrade()));
    }

}

package com.professor.controller;

import com.professor.model.AssessmentItem;
import com.professor.model.Course;
import com.professor.model.EnrolledCourse;
import com.professor.service.external.CourseService;
import com.professor.service.external.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/professor")
public class ProfessorController {


    private final StudentService studentService;
    private final CourseService courseService;

    @GetMapping("/ok")
    public String ok(){
        return "professor-service ok";
    }

    @PreAuthorize("hasAuthority('ROLE_INSTRUCTOR')")
    @PostMapping("/add-student")
    public ResponseEntity<EnrolledCourse> addCourseToStudent(@RequestBody EnrolledCourse course){

        return ResponseEntity.ok(studentService.addCourseToStudent(course));
    }

    @PreAuthorize("hasAuthority('ROLE_INSTRUCTOR')")
    @PostMapping("/add-assessment")
    public ResponseEntity<EnrolledCourse> addAssessmentToStudent(@RequestBody AssessmentItem assessmentItem){

        return ResponseEntity.ok(studentService.addAssessmentToStudent(assessmentItem));
    }

    @PreAuthorize("hasAuthority('ROLE_INSTRUCTOR')")
    @GetMapping("/get-courses/{instructorId}")
    public ResponseEntity<List<Course>> getCourses(@PathVariable String instructorId){
        return ResponseEntity.ok(courseService.getCourses(instructorId));
    }


}

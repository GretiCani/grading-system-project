package com.course.controller;

import com.course.entity.AssessmentItem;
import com.course.entity.Course;
import com.course.service.AssessmentService;
import com.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final AssessmentService assessmentService;

    @GetMapping("/ok")
    public String ok(){
        return "course-service ok";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course>findCourse(@PathVariable String id){
        return ResponseEntity.ok(courseService.find(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return ResponseEntity.ok(courseService.add(course));
    }
    @PutMapping
    public ResponseEntity<Course>updateCourse(@PathVariable String id,@RequestBody Course course){
        return ResponseEntity.ok(courseService.update(id,course));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        courseService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/list")
    public ResponseEntity<List<Course>>list(){
        return ResponseEntity.ok(courseService.list());
    }

    @GetMapping("/assessment/{id}")
    public ResponseEntity<AssessmentItem>findAssessment(@PathVariable String id){
        return ResponseEntity.ok(assessmentService.find(id).orElse(null));
    }

    @PostMapping("/assessment")
    public ResponseEntity<Course> addAssessment(@RequestBody Course course){
        return ResponseEntity.ok(courseService.add(course));
    }
    @PutMapping("/assessment/{id}")
    public ResponseEntity<Course>updateAssessment(@PathVariable String id,@RequestBody  Course course){
        return ResponseEntity.ok(courseService.update(id,course));
    }

    @DeleteMapping("/assessment/{id}")
    public ResponseEntity<Void> deleteAssessment(@PathVariable String id){
        courseService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/assessment/list")
    public ResponseEntity<List<Course>>listAssessment(){
        return ResponseEntity.ok(courseService.list());
    }







}

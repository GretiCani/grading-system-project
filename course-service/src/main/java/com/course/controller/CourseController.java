package com.course.controller;

import com.course.entity.AssessmentItem;
import com.course.entity.Course;
import com.course.service.AssessmentService;
import com.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final AssessmentService assessmentService;

    @GetMapping("/ok")
    public String ok(){
        IntStream.range(0,10).forEach(index -> {
            log.info("course-service  info log "+1);
        });
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
    public ResponseEntity<AssessmentItem> addAssessment(@RequestBody AssessmentItem assessmentItem){
        return ResponseEntity.ok(assessmentService.add(assessmentItem));
    }
    @PutMapping("/assessment/{id}")
    public ResponseEntity<AssessmentItem>updateAssessment(@PathVariable String id,@RequestBody  AssessmentItem assessmentItem){
        return ResponseEntity.ok(assessmentService.update(id,assessmentItem));
    }

    @DeleteMapping("/assessment/{id}")
    public ResponseEntity<Void> deleteAssessment(@PathVariable String id){
        assessmentService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/assessment/list")
    public ResponseEntity<List<AssessmentItem>>listAssessment(){
        return ResponseEntity.ok(assessmentService.list());
    }







}

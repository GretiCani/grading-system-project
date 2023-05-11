package com.course.service.impl;

import com.course.entity.Course;
import com.course.repository.CourseRepository;
import com.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Optional<Course> find(String id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course add(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(String id, Course course) {
        return courseRepository.findById(id).map(c-> courseRepository.save(Course.builder()
                .id(id).code(course.getCode()).semesterOffered(course.getSemesterOffered()).catalogData(course.getCatalogData())
                .instructorId(course.getInstructorId()).name(course.getName()).build())).orElse(null);
    }

    @Override
    public void delete(String id) {
         courseRepository.deleteById(id);
    }

    @Override
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findByInstructor(String instructorId) {
        return courseRepository.findByInstructorId(instructorId);
    }
}

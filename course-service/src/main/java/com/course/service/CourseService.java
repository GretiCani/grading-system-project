package com.course.service;

import com.course.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Optional<Course> find(String id);
    Course add(Course course);
    Course update(String id,Course course);
    void delete(String id);
    List<Course> list();
}

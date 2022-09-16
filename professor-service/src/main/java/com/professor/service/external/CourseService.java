package com.professor.service.external;

import com.professor.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourses(String instructorId);
}

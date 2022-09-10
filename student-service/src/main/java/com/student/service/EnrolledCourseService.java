package com.student.service;

import com.student.entity.EnrolledCourse;
import com.student.entity.Grade;

public interface EnrolledCourseService {

    EnrolledCourse add(EnrolledCourse course);
    EnrolledCourse addAssessment(String courseId, String studentId, Grade grade);
}

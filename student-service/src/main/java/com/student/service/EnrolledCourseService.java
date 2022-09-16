package com.student.service;

import com.student.entity.EnrolledCourse;
import com.student.entity.Grade;

import java.util.List;

public interface EnrolledCourseService {

    EnrolledCourse add(EnrolledCourse course);
    EnrolledCourse addAssessment(String courseId, String studentId, Grade grade);
    EnrolledCourse findByCourseIdAndStudentId(String courseId, String studentId);
    Long updateGrades(String courseId, String studentId, String assessmentId, String grade);
    List<EnrolledCourse> findCoursesByStudentId(String studentId);
    List<EnrolledCourse> findByCourseId(String courseId);
}

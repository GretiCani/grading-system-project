package com.student.repository;

public interface CustomEnrolledCourseRepository {
    Long updateGrades(String courseId, String studentId, String assessmentId, String grade);
}

package com.student.service.impl;


import com.student.entity.EnrolledCourse;
import com.student.entity.Grade;
import com.student.repository.EnrolledCourseRepository;
import com.student.service.EnrolledCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrolledCourseImpl implements EnrolledCourseService {

    private final EnrolledCourseRepository enrolledCourseRepository;
    private final MongoTemplate mongoTemplate;


    @Override
    public EnrolledCourse add(EnrolledCourse course) {
        return enrolledCourseRepository.save(course);
    }

    @Override
    public EnrolledCourse addAssessment(String courseId, String studentId, Grade grade) {
        return enrolledCourseRepository.findByCourseIdAndStudentId(courseId,studentId)
                .map(e->{
                    List<Grade> grades = e.getGrades();
                    grades.add(grade);
                    e.setGrades(grades);
                    return e;
                }).flatMap(e-> Optional.of(enrolledCourseRepository.save(e)))
                .orElse(null);
    }

    @Override
    public EnrolledCourse findByCourseIdAndStudentId(String courseId, String studentId) {
        return enrolledCourseRepository.findByCourseIdAndStudentId(courseId,studentId).orElse(null);
    }

    @Override
    public Long updateGrades(String courseId, String studentId, String assessmentId, String grade) {
        return enrolledCourseRepository.updateGrades(courseId, studentId, assessmentId, grade);
    }

    @Override
    public List<EnrolledCourse> findCoursesByStudentId(String studentId) {
        return enrolledCourseRepository.findByStudentId(studentId);
    }

    @Override
    public List<EnrolledCourse> findByCourseId(String courseId) {
        return enrolledCourseRepository.findByCourseId(courseId);
    }
}

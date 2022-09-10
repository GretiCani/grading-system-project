package com.student.service.impl;


import com.student.entity.EnrolledCourse;
import com.student.entity.Grade;
import com.student.repository.EnrolledCourseRepository;
import com.student.service.EnrolledCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrolledCourseImpl implements EnrolledCourseService {

    private final EnrolledCourseRepository enrolledCourseRepository;


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
}

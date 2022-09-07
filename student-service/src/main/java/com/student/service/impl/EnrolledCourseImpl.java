package com.student.service.impl;


import com.student.entity.EnrolledCourse;
import com.student.repository.EnrolledCourseRepository;
import com.student.service.EnrolledCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrolledCourseImpl implements EnrolledCourseService {

    private final EnrolledCourseRepository enrolledCourseRepository;


    @Override
    public EnrolledCourse add(EnrolledCourse course) {
        return enrolledCourseRepository.save(course);
    }
}

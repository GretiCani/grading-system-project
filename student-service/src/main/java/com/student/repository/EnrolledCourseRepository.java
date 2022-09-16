package com.student.repository;

import com.student.entity.EnrolledCourse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrolledCourseRepository extends MongoRepository<EnrolledCourse,String>, CustomEnrolledCourseRepository {

    Optional<EnrolledCourse> findByCourseIdAndStudentId(String courseId, String studentId);
    List<EnrolledCourse> findByStudentId(String studentId);
    List<EnrolledCourse> findByCourseId(String courseId);


}

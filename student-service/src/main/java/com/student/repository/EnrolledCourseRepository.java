package com.student.repository;

import com.student.entity.EnrolledCourse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolledCourseRepository extends MongoRepository<EnrolledCourse,String> {
}

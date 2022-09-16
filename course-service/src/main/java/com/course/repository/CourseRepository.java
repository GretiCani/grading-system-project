package com.course.repository;

import com.course.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends MongoRepository<Course,String > {

    List<Course> findByInstructorId(String instructorId);
}

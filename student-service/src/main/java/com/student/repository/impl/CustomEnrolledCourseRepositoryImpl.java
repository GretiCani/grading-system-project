package com.student.repository.impl;

import com.student.entity.EnrolledCourse;
import com.student.repository.CustomEnrolledCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CustomEnrolledCourseRepositoryImpl implements CustomEnrolledCourseRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public Long updateGrades(String courseId, String studentId, String assessmentId, String grade) {
        Query query = new Query().addCriteria(Criteria.where("courseId").is(courseId))
                .addCriteria(Criteria.where("studentId").is(studentId))
                .addCriteria(Criteria.where("grades").elemMatch(Criteria.where("assessmentId").is(assessmentId)));
        Update updateDefinition = new Update().set("grades.$.grade",grade);
        return mongoTemplate.updateFirst(query,updateDefinition, EnrolledCourse.class).getModifiedCount();
    }
}

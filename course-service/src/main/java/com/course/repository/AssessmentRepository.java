package com.course.repository;

import com.course.entity.AssessmentItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends MongoRepository<AssessmentItem,String > {
}

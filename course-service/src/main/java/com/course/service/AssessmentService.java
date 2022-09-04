package com.course.service;

import com.course.entity.AssessmentItem;

import java.util.List;
import java.util.Optional;

public interface AssessmentService {

    Optional<AssessmentItem> find(String id);
    AssessmentItem add(AssessmentItem assessmentItem);
    AssessmentItem update(String id,AssessmentItem assessmentItem);
    void delete(String id);
    List<AssessmentItem> list();
}

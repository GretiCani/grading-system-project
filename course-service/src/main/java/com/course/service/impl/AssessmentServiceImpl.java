package com.course.service.impl;

import com.course.entity.AssessmentItem;
import com.course.repository.AssessmentRepository;
import com.course.service.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentRepository assessmentRepository;

    @Override
    public Optional<AssessmentItem> find(String id) {
        return assessmentRepository.findById(id);
    }

    @Override
    public AssessmentItem add(AssessmentItem assessmentItem) {
        return assessmentRepository.save(assessmentItem);
    }

    @Override
    public AssessmentItem update(String id, AssessmentItem assessment) {
        return assessmentRepository.findById(id)
                .map(a-> assessmentRepository.save(AssessmentItem
                        .builder().id(id).courseId(a.getCourseId())
                        .name(assessment.getName()).weight(assessment.getWeight())
                        .build())).orElse(null);
    }

    @Override
    public void delete(String id) {
        assessmentRepository.deleteById(id);
    }

    @Override
    public List<AssessmentItem> list() {
        return assessmentRepository.findAll();
    }
}

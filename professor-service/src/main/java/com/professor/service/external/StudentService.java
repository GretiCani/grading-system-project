package com.professor.service.external;


import com.professor.model.AssessmentItem;
import com.professor.model.EnrolledCourse;

public interface StudentService {

    EnrolledCourse addCourseToStudent(EnrolledCourse enrolledCourse);
    EnrolledCourse addAssessmentToStudent(AssessmentItem assessmentItem);
}

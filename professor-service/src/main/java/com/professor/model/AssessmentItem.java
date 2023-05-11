package com.professor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AssessmentItem{

    private String courseId;
    private String studentId;
    private Grade grade;



}

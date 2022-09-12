package com.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation {
    private String courseId;
    private String studentId;
    private String studentEmail;
    private String assessmentId;
    private String grade;
}
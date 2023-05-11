package com.professor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrolledCourse {

    private String id;
    private String courseId;
    private String courseName;
    private String studentId;
    private List<Grade> grades;





}

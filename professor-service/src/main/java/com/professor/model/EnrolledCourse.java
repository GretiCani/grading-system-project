package com.professor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "enrolled-courses")
public class EnrolledCourse {

    private String id;
    private String courseId;
    private String courseName;
    private String studentId;
    private List<Grade> grades;





}

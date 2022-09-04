package com.course.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "courses")
public class Course extends BaseEntity{

    @Id
    private String id;
    private String code;
    private String name;
    private String semesterOffered;
    private String catalogData;
    private String instructorId;



}

package com.professor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Course{

    private String id;
    private String code;
    private String name;
    private String semesterOffered;
    private String catalogData;
    private String instructorId;



}
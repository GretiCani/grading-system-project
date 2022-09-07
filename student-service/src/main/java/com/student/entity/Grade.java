package com.student.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {

    private String assessmentId;
    private String assessmentName;
    private String weight;
    private String grade;
    }
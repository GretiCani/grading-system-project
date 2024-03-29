package com.course.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "assessment-item")
public class AssessmentItem extends BaseEntity{

    @Id
    private String id;
    private String name;
    private String weight;
    private String courseId;



}

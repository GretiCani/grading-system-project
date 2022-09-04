package com.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class BaseEntity {

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
}

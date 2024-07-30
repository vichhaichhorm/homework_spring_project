package com.example.mybatisdemohomeworksr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    private Integer courseId;
    private String courseName;
    private String description;
    private Instructors instructors;
}

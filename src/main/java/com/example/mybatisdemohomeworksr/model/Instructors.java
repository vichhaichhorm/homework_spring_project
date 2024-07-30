package com.example.mybatisdemohomeworksr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructors {
    private int instructorId;
    private String instructorName;
    private String email;
}

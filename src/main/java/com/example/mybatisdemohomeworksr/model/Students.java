package com.example.mybatisdemohomeworksr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Courses> courses;
}


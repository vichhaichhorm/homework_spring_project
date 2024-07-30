package com.example.mybatisdemohomeworksr.model.dto.request;

import com.example.mybatisdemohomeworksr.model.Courses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private List<Courses> courses;
}

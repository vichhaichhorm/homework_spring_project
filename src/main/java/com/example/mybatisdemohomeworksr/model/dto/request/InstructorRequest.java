package com.example.mybatisdemohomeworksr.model.dto.request;

import com.example.mybatisdemohomeworksr.model.Instructors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {
    private String instructorName;
    private String email;
}

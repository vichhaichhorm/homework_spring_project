package com.example.mybatisdemohomeworksr.service;

import com.example.mybatisdemohomeworksr.model.Students;
import com.example.mybatisdemohomeworksr.model.dto.request.InstructorRequest;
import com.example.mybatisdemohomeworksr.model.dto.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Students> getAllStudents();

    Students getByStudentById(Integer id);

    boolean deleteStudentById(Integer id);

    Students updateById(StudentRequest studentRequest, Integer id);
}

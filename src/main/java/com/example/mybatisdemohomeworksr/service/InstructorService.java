package com.example.mybatisdemohomeworksr.service;

import com.example.mybatisdemohomeworksr.model.Instructors;
import com.example.mybatisdemohomeworksr.model.dto.request.InstructorRequest;

import java.util.List;

public interface InstructorService {
    List<Instructors> getAllInstructor();

    Instructors getInstructorById(Integer id);

    Instructors updateInstructor( InstructorRequest instructorRequest,Integer id);

    String deleteInstructorById(Integer id);

    Instructors addedInstructor(InstructorRequest instructorRequest);
}

package com.example.mybatisdemohomeworksr.service;


import com.example.mybatisdemohomeworksr.model.Courses;
import com.example.mybatisdemohomeworksr.model.dto.request.CourseRequest;

import java.util.List;

public interface CourseService {
    List<Courses> getAllCourse();

    Courses getCourseById(Integer id);

    Courses addCourses(CourseRequest courseRequest);

    Courses deleteById(Integer id);

    Courses updateCourse(CourseRequest courseRequest, Integer id);
}

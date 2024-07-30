package com.example.mybatisdemohomeworksr.service.serviceimpl;

import com.example.mybatisdemohomeworksr.model.Courses;
import com.example.mybatisdemohomeworksr.model.dto.request.CourseRequest;
import com.example.mybatisdemohomeworksr.repository.CourseRepository;
import com.example.mybatisdemohomeworksr.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Courses> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    @Override
    public Courses getCourseById(Integer id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Courses addCourses(CourseRequest courseRequest) {
        return courseRepository.addCourses(courseRequest);
    }

    @Override
    public Courses deleteById(Integer id) {
        return courseRepository.deleteById(id);
    }

    @Override
    public Courses updateCourse(CourseRequest courseRequest, Integer id) {
        return courseRepository.updateCourse(courseRequest,id);
    }


}

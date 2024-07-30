package com.example.mybatisdemohomeworksr.controller;

import com.example.mybatisdemohomeworksr.model.Courses;
import com.example.mybatisdemohomeworksr.model.dto.request.CourseRequest;
import com.example.mybatisdemohomeworksr.model.response.APIResponse;
import com.example.mybatisdemohomeworksr.service.CourseService;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<APIResponse<List<Courses>>> getAllCourse(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "All course has been successfully fetched",
                        courseService.getAllCourse(),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Courses>> getCourseById(@PathVariable Integer id) {
        Courses course = courseService.getCourseById(id);

        if (course != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new APIResponse<>(
                            "Course found",
                            course,
                            HttpStatus.OK,
                            LocalDateTime.now()
                    )
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new APIResponse<>(
                            "Course not found",
                            null,
                            HttpStatus.NOT_FOUND,
                            LocalDateTime.now()
                    )
            );
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse<Courses>> addCourses(@RequestBody CourseRequest courseRequest){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "All course has been successfully fetched",
                        courseService.addCourses(courseRequest),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }

    @DeleteMapping("/deletedCourse/{id}")
    public Courses deleteById(@PathVariable Integer id){
        return courseService.deleteById(id);

    }

//    @PutMapping("/updated/{id}")
//    public ResponseEntity<APIResponse<Courses>> updateCourse(@RequestBody CourseRequest courseRequest, @PathVariable Integer id){
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new APIResponse<>(
//                        "All course has been successfully fetched",
//                        courseService. updateCourse(courseRequest,id),
//                        HttpStatus.OK,
//                        LocalDateTime.now()
//                )
//        );
//    }

    @PutMapping("/update/{id}")
    public Courses updateCourse(@RequestBody CourseRequest courseRequest, @PathVariable Integer id){
        return courseService.updateCourse(courseRequest,id);
    }




}

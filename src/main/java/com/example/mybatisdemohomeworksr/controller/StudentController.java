package com.example.mybatisdemohomeworksr.controller;

import com.example.mybatisdemohomeworksr.model.Instructors;
import com.example.mybatisdemohomeworksr.model.Students;
import com.example.mybatisdemohomeworksr.model.dto.request.InstructorRequest;
import com.example.mybatisdemohomeworksr.model.dto.request.StudentRequest;
import com.example.mybatisdemohomeworksr.model.response.APIResponse;
import com.example.mybatisdemohomeworksr.service.StudentService;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping
//    public List<Students> getAllStudents(){
//        return studentService.getAllStudents();
//    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<APIResponse<List<Students>>> getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "Get all Students has been successfully fetched",
                        studentService.getAllStudents(),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<APIResponse<Students>> getByStudentById(Integer id) {
        Students student = studentService.getByStudentById(id);
        if (student != null) {
            APIResponse<Students> response = new APIResponse<>("Get student by ID successful",
                    student, HttpStatus.OK, LocalDateTime.now());
            return ResponseEntity.ok(response);
        } else {
            APIResponse<Students> response = new APIResponse<>("Student not found",
                    null, HttpStatus.NOT_FOUND,
                    LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<APIResponse<String>> deleteStudentById(@PathVariable Integer id) {
        boolean isDeleted = studentService.deleteStudentById(id);
        if (isDeleted) {
            APIResponse<String> response = new APIResponse<>(
                    "Student deleted successfully",
                    HttpStatus.OK.toString(), HttpStatus.OK, LocalDateTime.now());
            return ResponseEntity.ok(response);
        } else {
            APIResponse<String> response = new APIResponse<>(
                    "Student not found",
                    HttpStatus.NOT_FOUND.toString(),
                    HttpStatus.NOT_FOUND, LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // error
    @PutMapping("/updateById/{id}")
    public ResponseEntity<APIResponse<Students>> updateById(@RequestBody StudentRequest studentRequest, @PathVariable Integer id) {
        Students students = studentService.updateById(studentRequest, id);
        if (students != null) {
            APIResponse<Students> response = new APIResponse<>(
                    "Student updated successfully",
                    students,
                    HttpStatus.OK,
                    LocalDateTime.now());
            return ResponseEntity.ok(response);
        } else {
            APIResponse<Students> response = new APIResponse<>(
                    "Student not found",
                    null,
                    HttpStatus.NOT_FOUND,
                    LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}

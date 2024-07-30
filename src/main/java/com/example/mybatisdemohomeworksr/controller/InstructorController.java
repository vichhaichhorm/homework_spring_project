package com.example.mybatisdemohomeworksr.controller;

import com.example.mybatisdemohomeworksr.model.Instructors;
import com.example.mybatisdemohomeworksr.model.dto.request.InstructorRequest;
import com.example.mybatisdemohomeworksr.model.response.APIResponse;
import com.example.mybatisdemohomeworksr.service.InstructorService;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.parsers.ReturnTypeParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructor")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

//    pagination
    @GetMapping("/getAllInstructor")
    public ResponseEntity<APIResponse<List<Instructors>>> getAllInstructor(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "All instructors has been successful fetched",
                        instructorService.getAllInstructor(),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Instructors>> getInstructorById(@PathVariable Integer id) {
        Instructors instructor = instructorService.getInstructorById(id);
        if (instructor != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new APIResponse<>(
                            "All instructors has been successful fetched",
                            instructor,
                            HttpStatus.OK,
                            LocalDateTime.now()
                    )
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new APIResponse<>(
                            "Instructor not found",
                            null,
                            HttpStatus.NOT_FOUND,
                            LocalDateTime.now()
                    )
            );
        }

    }

    @PostMapping("/instructor")
    public ResponseEntity<APIResponse<Instructors>> addedInstructor(@RequestBody InstructorRequest instructorRequest) {
        Instructors instructors = instructorService.addedInstructor(instructorRequest);
        if (instructors != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new APIResponse<>(
                            "Instructor added successfully",
                            instructors,
                            HttpStatus.CREATED,
                            LocalDateTime.now()
                    )
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new APIResponse<>(
                            "Instructor not found",
                            null,
                            HttpStatus.NOT_FOUND,
                            LocalDateTime.now()
                    )
            );
        }
    }

    // please let teacher help it
    @PutMapping("/updated/instructor/{id}")
    public ResponseEntity<APIResponse<Instructors>> updateInstructor(@RequestBody InstructorRequest instructorRequest, @PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "Instructor update success",
                        instructorService.updateInstructor(instructorRequest,id),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }

    @DeleteMapping("/deletedById/{id}")
    public String deleteInstructorById(@PathVariable Integer id){
        return instructorService.deleteInstructorById(id);
    }


}

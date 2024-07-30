package com.example.mybatisdemohomeworksr.service.serviceimpl;

import com.example.mybatisdemohomeworksr.model.Instructors;
import com.example.mybatisdemohomeworksr.model.dto.request.InstructorRequest;
import com.example.mybatisdemohomeworksr.repository.InstructorRepository;
import com.example.mybatisdemohomeworksr.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructors> getAllInstructor() {
        return instructorRepository.findAllInstructor();
    }

    @Override
    public Instructors getInstructorById(Integer id) {
        return instructorRepository.getInstructorById(id);
    }


    @Override
    public Instructors updateInstructor(InstructorRequest instructorRequest,Integer id) {
        return instructorRepository.updateInstructor(instructorRequest, id);
    }

    @Override
    public String deleteInstructorById(Integer id) {
        Boolean isDeleted = instructorRepository.deleteInstructorById(id);
        if (isDeleted != null && isDeleted) {
            return "Remove instructor successfully";
        } else {
            return "Remove instructor not successful";
        }
    }

    @Override
    public Instructors addedInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.addedInstructor(instructorRequest);
    }

}

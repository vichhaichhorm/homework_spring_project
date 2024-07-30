package com.example.mybatisdemohomeworksr.service.serviceimpl;

import com.example.mybatisdemohomeworksr.model.Students;
import com.example.mybatisdemohomeworksr.model.dto.request.InstructorRequest;
import com.example.mybatisdemohomeworksr.model.dto.request.StudentRequest;
import com.example.mybatisdemohomeworksr.repository.StudentRepository;
import com.example.mybatisdemohomeworksr.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Students> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Students getByStudentById(Integer id) {
        return studentRepository.getByStudentById(id);
    }
    @Override
    public boolean deleteStudentById(Integer id) {
        return studentRepository.deleteStudentById(id);
    }

    @Override
    public Students updateById(StudentRequest studentRequest, Integer id) {
        return studentRepository.updateById(studentRequest,id);
    }



}

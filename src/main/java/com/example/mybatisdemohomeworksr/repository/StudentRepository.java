package com.example.mybatisdemohomeworksr.repository;

import com.example.mybatisdemohomeworksr.model.Students;
import com.example.mybatisdemohomeworksr.model.dto.request.StudentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("""
        SELECT * FROM students_tb;
    """)
    @Results(id = "studentMapper" ,value = {
            @Result(property = "id", column = "student_id"),
            @Result(property = "name", column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id",
                    javaType = List.class,
                    many = @Many(select = "com.example.mybatisdemohomeworksr.repository.CourseRepository" +
                            ".getCoursesByStudentId"))
    })
    List<Students> getAllStudents();

    @Select("""
        SELECT * FROM students_tb WHERE student_id=#{id}
    """)
    @ResultMap({"studentMapper"})
    Students getByStudentById(Integer id);


    @Delete("DELETE FROM students_tb WHERE student_id = #{id}")
    @ResultMap({"studentMapper"})
    boolean deleteStudentById(Integer id);

    @Update("""
        UPDATE students_tb 
        SET student_name = #{studentRequest.name}, 
            email = #{studentRequest.email}, 
            phone_number = #{studentRequest.phoneNumber}
        WHERE student_id = #{id}
        RETURNING *;
    """)
    @ResultMap({"studentMapper"})
    Students updateById(@Param("studentRequest") StudentRequest studentRequest,Integer id);



}

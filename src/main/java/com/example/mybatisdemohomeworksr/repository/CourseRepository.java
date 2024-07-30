package com.example.mybatisdemohomeworksr.repository;

import com.example.mybatisdemohomeworksr.model.Courses;
import com.example.mybatisdemohomeworksr.model.dto.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Select("""
        SELECT * FROM student_course sc INNER JOIN courses_tb cb 
            ON sc.course_id = cb.course_id where sc.student_id=#{id};
    """)
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId",column = "course_id"),
            @Result(property = "courseName",column = "course_name"),
            @Result(property = "description",column = "course_description"),
            @Result(property = "instructors",column = "instructor_id",
                one = @One(select = "com.example.mybatisdemohomeworksr.repository.InstructorRepository.getInstructorById")
            )
    })
    List<Courses> getAllCourse();

//    join table
    @Select("""
        SELECT * FROM courses_tb c
        INNER JOIN student_course sc ON c.course_id = sc.course_id
        WHERE sc.student_id = #{studentId}
    """)

    @ResultMap({"courseMapper"})
    List<Courses> getCoursesByStudentId(Integer studentId);
    @Select("""
        SELECT * FROM courses_tb  where course_id=#{id}
    """)
    @ResultMap({"courseMapper"})
    Courses getCourseById(Integer id);

    @Select("""
        INSERT INTO courses_tb(course_name, course_description, instructor_id)
        VALUES (#{courseRequest.courseName}, #{courseRequest.description}, #{courseRequest.instructors}) RETURNING *
    """)
    @ResultMap({"courseMapper"})
    Courses addCourses(@Param("courseRequest") CourseRequest courseRequest);

    @Select("""
        DELETE FROM courses_tb where course_id=#{id} 
    """)
    @ResultMap({"courseMapper"})
    Courses deleteById(Integer id);


    @Select("""
        UPDATE courses_tb SET course_name=#{courses.courseName}, course_description=#{courses.description}
        ,instructor_id=#{courses.instructors}
        where course_id=#{id}
    """)
    @ResultMap({"courseMapper"})
    Courses updateCourse(@Param("courses") CourseRequest courseRequest, Integer id);
}

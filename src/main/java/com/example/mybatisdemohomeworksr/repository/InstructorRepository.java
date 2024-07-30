package com.example.mybatisdemohomeworksr.repository;

import com.example.mybatisdemohomeworksr.model.Instructors;
import com.example.mybatisdemohomeworksr.model.dto.request.InstructorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Select("""
        SELECT * FROM instructors_tb
    """)
    @Results(id = "instructorMapper",value = {
            @Result(property = "instructorId",column = "instructor_id"),
            @Result(property = "instructorName",column = "instructor_name")
    })
    List<Instructors> findAllInstructor();

    @Select("""
        SELECT  * FROM instructors_tb where instructor_id=#{id}
    """)
    @ResultMap({"instructorMapper"})
    Instructors getInstructorById(Integer id);

    @Select("""
        UPDATE instructors_tb SET instructor_name=#{instructors.instructorName},email=#{instructors.email}
        where instructor_id=#{id}
    """)
    @ResultMap({"instructorMapper"})
    Instructors updateInstructor(@Param("instructors") InstructorRequest instructorRequest,Integer id);

    @Delete(" DELETE FROM instructors_tb where instructor_id= #{id}")
    @ResultMap({"instructorMapper"})
    Boolean deleteInstructorById(Integer id);


    @Select("""
        INSERT INTO instructors_tb (instructor_name,email)
        VALUES (#{instructors.instructorName},#{instructors.email}) RETURNING *
    """)
    @ResultMap({"instructorMapper"})
    Instructors addedInstructor(@Param("instructors") InstructorRequest instructorRequest);


}

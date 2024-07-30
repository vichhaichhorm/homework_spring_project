drop database students_khrd_sr;
create database students_khrd_sr;
create table instructors_tb(
  instructor_id serial primary key ,
  instructor_name varchar(50),
  email varchar(125)
);

drop table instructors_tb;

insert into instructors_tb (instructor_name,email)
values ('vichhai chhorm','vichhaichhorm169@gmail.com'),
    ('chhayhour chhea','chhayhourchhea169@gmail.com'),
    ('sovan koko','sovanchhaikoko@gmail.com');

select * from instructors_tb;
CREATE TABLE courses_tb (
                            course_id SERIAL PRIMARY KEY,
                            course_name VARCHAR(50),
                            course_description VARCHAR(400),
                            instructor_id INT,
                            CONSTRAINT instructors_fk FOREIGN KEY (instructor_id)
                            REFERENCES instructors_tb(instructor_id)
                            ON UPDATE CASCADE ON DELETE CASCADE
);


select * from courses_tb;
INSERT INTO courses_tb (course_name,course_description,instructor_id)
VALUES
    ('Next js', 'web page', 1),
    ('Java', 'basic course', 2),
    ('Java spring', 'basic spring', 3);



drop table students_tb;
CREATE TABLE students_tb(
    student_id serial primary key ,
    student_name varchar(55),
    email varchar(30),
    phone_number varchar(18)

);


INSERT INTO students_tb(student_name,email,phone_number)
VALUES ('koko','koko@gmail.com','+855 873 228 00'),
       ('Moko','Moko@gmail.com','+855 873 228 00'),
       ('Loko','Loko@gmail.com','+855 873 228 00');

SELECT *FROM students_tb;

CREATE TABLE student_course (
    id SERIAL PRIMARY KEY,
    student_id INTEGER,
    course_id INTEGER,
    CONSTRAINT fk_student FOREIGN KEY (student_id)
    REFERENCES students_tb(student_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_course FOREIGN KEY (course_id)
    REFERENCES courses_tb(course_id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

SELECT * from student_course;

INSERT INTO student_course(student_id,course_id)
values (1,1),
       (2,3),
       (3,2);



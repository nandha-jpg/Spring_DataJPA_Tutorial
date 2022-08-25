package com.nandha.learnings.spring.datajpa.repository;

import com.nandha.learnings.spring.datajpa.entity.Course;
import com.nandha.learnings.spring.datajpa.entity.CourseMaterial;
import com.nandha.learnings.spring.datajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        CourseMaterial courseMaterialJava = CourseMaterial.builder()
                .url("www.java.com").build();

        CourseMaterial courseMaterialPHP = CourseMaterial.builder()
                .url("www.php.com").build();

        Course course1 = Course.builder()
                .title(".Net")
                .credits(3).build();

        Course course = new Course();
        course.setTitle("php");
        course.setCredits(4);
        //course.setCourseMaterial(courseMaterialPHP);

        Teacher teacher = Teacher.builder()
                .firstName("Murugan")
                .lastName("Swamyvel")
                .courses(Arrays.asList(course,course1)).build();

        teacherRepository.save(teacher);
    }

}
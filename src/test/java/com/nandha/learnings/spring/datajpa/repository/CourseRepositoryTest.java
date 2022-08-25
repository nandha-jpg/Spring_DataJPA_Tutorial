package com.nandha.learnings.spring.datajpa.repository;

import com.nandha.learnings.spring.datajpa.entity.Course;
import com.nandha.learnings.spring.datajpa.entity.CourseMaterial;
import com.nandha.learnings.spring.datajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCoursesWithTeacher(){

        CourseMaterial courseMaterialDSP= CourseMaterial.builder()
                .url("www.DSP.com").build();

        Teacher teacher = Teacher.builder()
                .firstName("Mohammed")
                .lastName("Azar")
                .build();

        Course course = Course.builder()
                .title("DSP")
                .credits(4)
                .teacher(teacher)
                .courseMaterial(courseMaterialDSP)
                .build();

        courseRepository.save(course);
    }
}
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
                .url("www.java.com")
                .build();

        CourseMaterial courseMaterialCSH = CourseMaterial.builder()
                .url("www.c#.com")
                .build();

        Course course1 = Course.builder()
                .title("Java")
                .courseMaterial(courseMaterialJava)
                .credits(5)
                .build();

        Course course = new Course();
        course.setTitle("c#");
        course.setCredits(4);
        course.setCourseMaterial(courseMaterialCSH);

        Teacher teacher = Teacher.builder()
                .firstName("Samraj")
                .lastName("Thangavel")
                //.courses(Arrays.asList(course,course1)) //commented out for making Many to One mapping instead of One to Many
                .build();

        teacherRepository.save(teacher);
    }

}
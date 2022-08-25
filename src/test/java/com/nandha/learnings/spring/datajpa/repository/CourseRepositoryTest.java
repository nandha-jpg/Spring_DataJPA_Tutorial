package com.nandha.learnings.spring.datajpa.repository;

import com.nandha.learnings.spring.datajpa.entity.Course;
import com.nandha.learnings.spring.datajpa.entity.CourseMaterial;
import com.nandha.learnings.spring.datajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

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

    @Test
    public void findAllPagination(){

        Pageable firstPageWithTwoRecords = PageRequest.of(0,1);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);
        List<Course> courses = courseRepository.findAll(firstPageWithTwoRecords).getContent();

        Long elements = courseRepository.findAll(firstPageWithTwoRecords).getTotalElements();

        int pages = courseRepository.findAll(firstPageWithTwoRecords).getTotalPages();

        System.out.println("courses = " + courses);
        System.out.println("total pages = " + pages);
        System.out.println("total elements = " + elements);
    }
}
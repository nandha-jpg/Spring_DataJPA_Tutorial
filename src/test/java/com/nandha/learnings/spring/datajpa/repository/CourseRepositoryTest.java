package com.nandha.learnings.spring.datajpa.repository;

import com.nandha.learnings.spring.datajpa.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
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

    @Test
    public void  saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Kavi")
                .lastName("Nilavan")
                .build();

        Guardian guardian = Guardian.builder()
                .name("Annamalai")
                .email("a.malai@mail.com")
                .mobileNumber("987654321")
                .build();

        Student student = Student.builder()
                .firstName("Abinesh")
                .lastName("Kumar")
                .emailAddress("abi.k@mail.com")
                .guardian(guardian)
                .build();

        Student student1 = Student.builder()
                .firstName("Robin")
                .lastName("Uthappa")
                .emailAddress("robi.up@mail.com")
                .guardian(guardian)
                .build();


        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.dataintelligencecluster.com")

                .build();

        Course course = Course.builder()
                .title("Machine Learning")
                .credits(5)
                .students(Arrays.asList(student,student1))
                .teacher(teacher)
                .courseMaterial(courseMaterial)
                .build();

        //course.addStudent(student);
        //course.addStudent(student1);

        courseRepository.save(course);
    }
}
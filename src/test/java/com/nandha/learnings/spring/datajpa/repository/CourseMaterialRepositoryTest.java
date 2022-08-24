package com.nandha.learnings.spring.datajpa.repository;

import com.nandha.learnings.spring.datajpa.entity.Course;
import com.nandha.learnings.spring.datajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial()  {
        Course course = Course.builder()
                .title("DSA")
                .credits(5)
                .build();

        CourseMaterial courseMaterial = new CourseMaterial();
        courseMaterial.setUrl("www.google.com");
        courseMaterial.setCourse(course);

        courseMaterialRepository.save(courseMaterial);
    }

}
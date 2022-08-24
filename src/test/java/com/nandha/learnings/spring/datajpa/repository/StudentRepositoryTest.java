package com.nandha.learnings.spring.datajpa.repository;

import com.nandha.learnings.spring.datajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest /*This will help you to test the repository layer and once the operation is done, it will flush the data.
//               So, the database won't be impacted.'*/
@SpringBootTest //Ideally you should not use this annotation to test the repository layer. But currently, we want the database to be impacted
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("Nandha")
                .lastName("Kumar")
                .emailAddress("nandha@mail.com")
                .guardianName("MuthuSamy")
                .guardianMobile("9494949494")
                .guardianEmail("muthusamy@mail.com")
                .build();

        studentRepository.save(student);
    }
}
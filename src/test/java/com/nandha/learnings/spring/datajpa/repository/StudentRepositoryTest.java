package com.nandha.learnings.spring.datajpa.repository;

import com.nandha.learnings.spring.datajpa.entity.Guardian;
import com.nandha.learnings.spring.datajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
                /*.guardianName("MuthuSamy")
                .guardianMobile("9494949494")
                .guardianEmail("muthusamy@mail.com")*/
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Muthusamy")
                .mobileNumber("979797979")
                .email("muthusamy@mail.com")
                .build();
        /*guardian.setName("Grusamy");
        guardian.setEmail("gurusamy@mail.com");
        guardian.setMobileNumber("9898989898");*/


        /*Student student = new Student();
        student.setFirstName("Eswara");
        student.setLastName("Moorthi");
        student.setEmailAddress("eswara.m@mail.com");
        student.setGuardian(guardian);*/

        Student students =Student.builder()
                .firstName("Eswara")
                .lastName("Moorthi")
                .emailAddress("eswara.m@mail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(students);
    }

    @Test
    public void getAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("students = " + students);
        assertTrue(students.size() > 0);
    }
}
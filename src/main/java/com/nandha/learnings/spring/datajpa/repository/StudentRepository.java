package com.nandha.learnings.spring.datajpa.repository;

import com.nandha.learnings.spring.datajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByFirstName(String firstName);
    List<Student> findStudentByLastName(String lastName);
    List<Student> findStudentByFirstNameContaining(String name);

    //JPQL (This is defined based on the classes and attributes that you have created)
    @Query("select s from Student s where s.firstName = ?1")
    Student getStudentByFirstName(String firstName);
}

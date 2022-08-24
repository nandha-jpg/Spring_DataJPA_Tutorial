package com.nandha.learnings.spring.datajpa.repository;

import com.nandha.learnings.spring.datajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("select s.lastName from Student s where s.emailAddress = ?1")
    String getStudentLastNameByEmail(String emailAddress);

    //Native query
    @Query(value = "select * from student_tbl where first_name = ?1",
            nativeQuery = true)
    Student getStudentByFirstNameNativeQuery(String firstName);

    @Query(value = "select s.last_name from student_tbl s where s.email = ?1",
            nativeQuery = true)
    String getStudentLastNameByEmailNative(String email);

    //Native query Named Param
    @Query(value = "select s.last_name from student_tbl s where s.email = :email",
            nativeQuery = true)
    String getStudentLastNameByEmailNativeNamedParam(@Param("email") String email);

}

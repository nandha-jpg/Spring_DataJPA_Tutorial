package com.nandha.learnings.spring.datajpa.repository;

import com.nandha.learnings.spring.datajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
    @Query(value = "select * from student_table where first_name = ?1",
            nativeQuery = true)
    Student getStudentByFirstNameNativeQuery(String firstName);

    @Query(value = "select s.last_name from student_table s where s.email = ?1",
            nativeQuery = true)
    String getStudentLastNameByEmailNative(String email);

    //Native query Named Param
    @Query(value = "select s.last_name from student_table s where s.email = :email",
            nativeQuery = true)
    String getStudentLastNameByEmailNativeNamedParam(@Param("email") String email);

    @Transactional //usually this annotation should be placed in service layer only, but for JPA's sake we are using it here
    @Modifying //use it when you need to modify the records in database(update/delete)
    @Query(value = "update student_table s set s.first_name= ?1 where email = ?2",
            nativeQuery = true)
    void updateStudentFirstNameByEmail(String first_name,String email);

}

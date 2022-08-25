package com.nandha.learnings.spring.datajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Course", uniqueConstraints = @UniqueConstraint(name = "uc_course_course_title", columnNames = {"course_title"}))
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_title")
    private String title;

    @Column(name = "course_credits")
    private Integer credits;


    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "course", cascade = CascadeType.ALL, optional = false)
    private CourseMaterial courseMaterial;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_student_mapping",
            joinColumns = @JoinColumn(name = "course_id",referencedColumnName = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
    private List<Student> students;

    public void addStudent(Student student){
        if ( students == null ) students = new ArrayList<>();
        else students.add(student);
    }
}

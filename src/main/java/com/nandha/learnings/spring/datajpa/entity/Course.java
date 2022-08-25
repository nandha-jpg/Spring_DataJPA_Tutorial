package com.nandha.learnings.spring.datajpa.entity;

import lombok.*;

import javax.persistence.*;

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


    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;
}

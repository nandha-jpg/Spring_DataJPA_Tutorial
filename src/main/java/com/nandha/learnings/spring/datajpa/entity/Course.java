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


}

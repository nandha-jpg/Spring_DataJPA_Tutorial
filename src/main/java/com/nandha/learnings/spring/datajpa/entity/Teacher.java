package com.nandha.learnings.spring.datajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @Column(name = "teacher_id")
    private Long id;

    private String firstName;
    private String lastName;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    @ToString.Exclude
    private List<Course> courses;*/ //commenting out just to make Many to One mapping
}

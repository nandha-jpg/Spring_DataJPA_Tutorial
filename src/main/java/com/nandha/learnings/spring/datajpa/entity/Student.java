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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "student_table",
        uniqueConstraints = @UniqueConstraint(
                name = "uc_email",
                columnNames = {"email"}))
public class Student {
    @Id
    @Column(name = "student_id")
    @SequenceGenerator(name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_sequence")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email",
            nullable = false,
            unique = true)
    private String emailAddress;

    @Embedded
    private Guardian guardian;

}

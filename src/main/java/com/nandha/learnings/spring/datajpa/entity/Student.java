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
@Table(name = "student_tbl",
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

    @Column(name = "guardian_name")
    private String guardianName;

    @Column(name = "guardian_email",
            nullable = false,
            unique = true)
    private String guardianEmail;

    @Column(name = "guardian_mobile",
            unique = true)
    private String guardianMobile;

}

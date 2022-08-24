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
public class Student {
    @Id
    private Long studentId;
    private String firstName;
    private String lastName;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;

}

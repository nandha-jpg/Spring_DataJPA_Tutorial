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
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
    @SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
    @Column(name = "course_material_id")
    private Long id;

    @Column(name = "course_material_url")
    private String url;
}

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

//@Table(name = "CourseMaterials")
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
    @SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
    @Column(name = "course_material_id")
    private Long id;

    @Column(name = "course_material_url")
    private String url;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ToString.Exclude
    private Course course;
}

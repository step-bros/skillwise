package com.stepbros.skillwise.courses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class CourseEntity {
    @Id
    @Column(name = "id")
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "description")
    String description;
    @Column(name = "logoUrl")
    String logoUrl;
    @Column(name = "thumbnailUrl")
    String thumbnailUrl;
    @Column(name = "reward")
    Integer reward;

    @OneToMany(mappedBy = "course")
    @Transient
    private Set<CourseProgress> progresses;

    public CourseEntity(Integer id, String name, String description, String logoUrl, String thumbnailUrl, Integer reward) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.logoUrl = logoUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.reward = reward;
    }
}

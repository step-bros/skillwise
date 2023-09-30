package com.stepbros.skillwise.user;

import com.stepbros.skillwise.courses.CourseProgress;
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
@Table(name="student")
public class StudentEntity {
    @Id
    @Column(name = "id")
    Integer id;
    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "student")
    @Transient
    private Set<CourseProgress> progresses;

    public StudentEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}

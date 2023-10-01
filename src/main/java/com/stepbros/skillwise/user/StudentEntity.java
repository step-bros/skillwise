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

    public StudentEntity(Integer id, String name, Integer streak, Integer gold) {
        this.id = id;
        this.name = name;
        this.streak = streak;
        this.gold = gold;
    }

    @Column(name = "name")
    String name;
    @Column(name = "streak")
    Integer streak;
    @Column(name = "gold")
    Integer gold;

    @OneToMany(mappedBy = "student")
    @Transient
    private Set<CourseProgress> progresses;
}

package com.stepbros.skillwise.courses;

import com.stepbros.skillwise.user.StudentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    CourseEntity course;

    @Column(name = "progress")
    Integer progress;

    public CourseProgress(StudentEntity student, CourseEntity course, Integer progress) {
        this.student = student;
        this.course = course;
        this.progress = progress;
    }
}

package com.stepbros.skillwise.reward;

import com.stepbros.skillwise.courses.CourseEntity;
import com.stepbros.skillwise.user.StudentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RewardClaimed {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "reward_id")
    RewardEntity reward;

    public RewardClaimed(StudentEntity student, RewardEntity reward) {
        this.student = student;
        this.reward = reward;
    }
}

package com.stepbros.skillwise.courses;

import com.stepbros.skillwise.user.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseProgressRepository extends JpaRepository<CourseProgress, Long> {
    CourseProgress findByStudentAndCourse(StudentEntity student, CourseEntity course);
    List<CourseProgress> findAllByStudent(StudentEntity studentEntity);
}

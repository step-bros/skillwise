package com.stepbros.skillwise.user;

import com.stepbros.skillwise.courses.CourseEntity;
import com.stepbros.skillwise.courses.CourseProgress;
import com.stepbros.skillwise.courses.CourseProgressRepository;
import com.stepbros.skillwise.courses.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class StudentController {
    private final StudentRepository studentRepository;
    private final CourseProgressRepository courseProgressRepository;
    private final CourseRepository courseRepository;

    StudentController(StudentRepository studentRepository, CourseProgressRepository courseProgressRepository, CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.courseProgressRepository = courseProgressRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping(path="student/{name}")
    StudentEntity getStudent(@PathVariable String name) {
        return studentRepository.findByName(name);
    }

    @GetMapping(path = "student/{studentName}/courses")
    List<CourseEntity> getStudentCourses(@PathVariable String studentName){
        StudentEntity studentEntity = studentRepository.findByName(studentName);
        List<CourseProgress> progresses = this.courseProgressRepository.findAllByStudent(studentEntity);
        return this.courseRepository.findAllById(progresses.stream().map(progress -> {
            return progress.getCourse().getId();
        }).toList());
    }

    @GetMapping(path="student/{studentName}/progress")
    Integer getStudentCourseProgress(@PathVariable String studentName, @RequestParam String courseName)
    {
        StudentEntity studentEntity = studentRepository.findByName(studentName);
        CourseEntity courseEntity = courseRepository.findByName(courseName);

        return this.courseProgressRepository.findByStudentAndCourse(studentEntity, courseEntity).getProgress();
    }
}

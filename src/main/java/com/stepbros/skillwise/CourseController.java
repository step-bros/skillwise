package com.stepbros.skillwise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
public class CourseController {
    private final CourseRepository courseRepository;
    CourseController(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @GetMapping(path = "courses")
    List<CourseEntity> getAllCourses(){
        return courseRepository.findAll();
    }
}

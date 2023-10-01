package com.stepbros.skillwise.user;

import com.stepbros.skillwise.courses.CourseEntity;
import com.stepbros.skillwise.courses.CourseProgress;
import com.stepbros.skillwise.courses.CourseProgressRepository;
import com.stepbros.skillwise.courses.CourseRepository;
import com.stepbros.skillwise.reward.RewardClaimed;
import com.stepbros.skillwise.reward.RewardClaimedRepository;
import com.stepbros.skillwise.reward.RewardEntity;
import com.stepbros.skillwise.reward.RewardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@ResponseBody
public class StudentController {
    private final StudentRepository studentRepository;
    private final CourseProgressRepository courseProgressRepository;
    private final CourseRepository courseRepository;

    private final RewardRepository rewardRepository;
    private final RewardClaimedRepository rewardClaimedRepository;

    StudentController(StudentRepository studentRepository, CourseProgressRepository courseProgressRepository, CourseRepository courseRepository, RewardRepository rewardRepository, RewardClaimedRepository rewardClaimedRepository){
        this.studentRepository = studentRepository;
        this.courseProgressRepository = courseProgressRepository;
        this.courseRepository = courseRepository;
        this.rewardRepository = rewardRepository;
        this.rewardClaimedRepository = rewardClaimedRepository;
    }

    @CrossOrigin
    @GetMapping(path="student/{name}")
    StudentEntity getStudent(@PathVariable String name) {
        return studentRepository.findByName(name);
    }

    @CrossOrigin
    @GetMapping(path = "student/{studentName}/courses")
    List<CourseEntity> getStudentCourses(@PathVariable String studentName){
        StudentEntity studentEntity = studentRepository.findByName(studentName);
        List<CourseProgress> progresses = this.courseProgressRepository.findAllByStudent(studentEntity);
        return this.courseRepository.findAllById(progresses.stream().map(progress -> {
            return progress.getCourse().getId();
        }).toList());
    }

    @CrossOrigin
    @GetMapping(path="student/{studentName}/progress")
    Integer getStudentCourseProgress(@PathVariable String studentName, @RequestParam String courseName)
    {
        StudentEntity studentEntity = studentRepository.findByName(studentName);
        CourseEntity courseEntity = courseRepository.findByName(courseName);

        return this.courseProgressRepository.findByStudentAndCourse(studentEntity, courseEntity).getProgress();
    }

    @CrossOrigin
    @PostMapping(path="student/{studentName}/enroll")
    StudentEntity enrollStudent(@PathVariable String studentName, @RequestParam String courseName)
    {
        StudentEntity studentEntity = studentRepository.findByName(studentName);
        CourseEntity courseEntity = courseRepository.findByName(courseName);

        studentEntity.gold += courseEntity.getReward();
        studentRepository.save(studentEntity);

        this.courseProgressRepository.save(new CourseProgress(studentEntity, courseEntity, 0));
        return studentEntity;
    }

    @CrossOrigin
    @PostMapping(path="student/{studentName}/claim")
    StudentEntity claimReward(@PathVariable String studentName, @RequestParam String rewardName) throws Exception {
        StudentEntity studentEntity = studentRepository.findByName(studentName);
        RewardEntity rewardEntity = rewardRepository.findByName(rewardName);

        if (studentEntity.gold - rewardEntity.getCost() > 0){
            studentEntity.gold -= rewardEntity.getCost();
            studentRepository.save(studentEntity);
        }
        else
            throw new Exception("Insufficient gold.");

        this.rewardClaimedRepository.save(new RewardClaimed(studentEntity, rewardEntity ));
        return studentEntity;
    }
}

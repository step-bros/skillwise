package com.stepbros.skillwise;

import com.stepbros.skillwise.courses.CourseProgress;
import com.stepbros.skillwise.courses.CourseEntity;
import com.stepbros.skillwise.courses.CourseProgressRepository;
import com.stepbros.skillwise.courses.CourseRepository;
import com.stepbros.skillwise.user.StudentEntity;
import com.stepbros.skillwise.user.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class SkillwiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillwiseApplication.class, args);
	}

	@Transactional
	@Bean
	public CommandLineRunner setup(CourseRepository courseRepository, CourseProgressRepository progressRepository, StudentRepository studentRepository){
		return (args) -> {
			CourseEntity webDevelopmentBootCampCourse = new CourseEntity(
					0,
					"The Complete 2023 Web Development Bootcamp",
					"Become a Full-Stack Web Developer with just ONE course. HTML, CSS, Javascript, Node, React, MongoDB, Web3 and DApps",
					"assets/logos/udemy.svg",
					"assets/thumbnails/web-dev.png",
					20);

			CourseEntity flutterFirebaseCourse = new CourseEntity(
					1,
					"Add Firebase to your Flutter app",
					"Learn how to integrate Firebase products to your Flutter app, for seamless frontend and backend mobile app development.",
					"assets/logos/firebase.svg",
					"assets/thumbnails/flutter.png",
					40);

			StudentEntity student = new StudentEntity(
					0,
					"Darrick"
			);

			courseRepository.save(webDevelopmentBootCampCourse);
			courseRepository.save(flutterFirebaseCourse);

			studentRepository.save(student);

			CourseProgress progress = new CourseProgress(0L, student, webDevelopmentBootCampCourse, 50);
			progressRepository.save(progress);

//			Set<CourseProgress> progressSet = Set.of(progress);

//			student.setProgresses(progressSet);
//			webDevelopmentBootCampCourse.setProgresses(progressSet);
		};
	}
}

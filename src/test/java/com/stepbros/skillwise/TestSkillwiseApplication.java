package com.stepbros.skillwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSkillwiseApplication {

	public static void main(String[] args) {
		SpringApplication.from(SkillwiseApplication::main).with(TestSkillwiseApplication.class).run(args);
	}

}

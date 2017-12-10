package com.dbbyte.quizzes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class QuizzesApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext cac = SpringApplication.run(QuizzesApplication.class, args);
	}
}

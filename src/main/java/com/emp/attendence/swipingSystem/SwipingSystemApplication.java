package com.emp.attendence.swipingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SwipingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwipingSystemApplication.class, args);
	}

}

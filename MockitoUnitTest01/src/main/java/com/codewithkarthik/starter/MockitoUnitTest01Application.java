package com.codewithkarthik.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.codewithkarthik")
public class MockitoUnitTest01Application {

	public static void main(String[] args) {
		SpringApplication.run(MockitoUnitTest01Application.class, args);
	}

}

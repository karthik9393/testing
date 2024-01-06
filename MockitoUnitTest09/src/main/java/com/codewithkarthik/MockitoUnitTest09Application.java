package com.codewithkarthik;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Implementing controller layer testing with service class mock.
//Implementing service layer testing with repository mock.
//Implementing repository layer testing.
@SpringBootApplication
@ComponentScan("com.codewithkarthik")
@EnableJpaRepositories("com.codewithkarthik.repository")
@EntityScan("com.codewithkarthik.entity")
public class MockitoUnitTest09Application {

	public static void main(String[] args) {
		SpringApplication.run(MockitoUnitTest09Application.class, args);
	}

}

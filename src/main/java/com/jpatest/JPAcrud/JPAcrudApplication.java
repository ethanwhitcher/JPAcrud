package com.jpatest.JPAcrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JPAcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JPAcrudApplication.class, args);
	}

	// spring boot runs all CommandLineRunner beans once application context is loaded
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student john = new Student(
					"john", "doe", "johndoe@gmail.com", 50
			);
			studentRepository.save(john);
		};
	}


}

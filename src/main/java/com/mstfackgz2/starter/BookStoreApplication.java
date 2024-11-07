package com.mstfackgz2.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.mstfackgz2")
@EnableJpaRepositories(basePackages = {"com.mstfackgz2"})
@EntityScan(basePackages = {"com.mstfackgz2"})
@ComponentScan(basePackages = {"com.mstfackgz2"})
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
		
		
	}
	
}

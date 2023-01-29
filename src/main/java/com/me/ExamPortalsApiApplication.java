package com.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.me.*"})
@SpringBootApplication
public class ExamPortalsApiApplication {
	
	 

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalsApiApplication.class, args);
		System.out.println("stating application");
	}
	
	

}

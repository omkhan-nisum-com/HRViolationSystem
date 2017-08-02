package com.nisum.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class HrViolationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrViolationSystemApplication.class, args);
	}
	
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HrViolationSystemApplication.class);
		
	}
	
	private static Class<SpringApplicationBuilder> applicationClass = SpringApplicationBuilder.class;
}

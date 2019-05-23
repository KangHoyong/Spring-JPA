package com.example.demo;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication {

	private static final String PROPERTIES = "spring.config.location=classpath:/google.yml";

	public static void main(String[] args) {
		new SpringApplicationBuilder(DemoApplication.class)
				.properties(PROPERTIES)
				.run(args);
	}

}

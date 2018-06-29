package com.example.sample01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Sample01Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Sample01Application.class, args);
	}
}

package com.ganga.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ganga")
@EnableJpaRepositories(basePackages = "com.ganga.dao")
@EntityScan(basePackages = "com.ganga.entities")
public class MultiEmployeeManagementApp {
	public static void main(String[] args) {
		SpringApplication.run(MultiEmployeeManagementApp.class, args);
	}
}

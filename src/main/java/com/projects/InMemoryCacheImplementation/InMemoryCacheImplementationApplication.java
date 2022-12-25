package com.projects.InMemoryCacheImplementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class InMemoryCacheImplementationApplication {

	public static void main(String[] args) {
		SpringApplication.run(InMemoryCacheImplementationApplication.class, args);
	}

}

package com.qhala.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"controllers", "models", "services", "repositories"})
@EntityScan("models")
@EnableJpaRepositories(basePackages={"repositories"})
public class QhalaLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(QhalaLibraryApplication.class, args);
	}

}

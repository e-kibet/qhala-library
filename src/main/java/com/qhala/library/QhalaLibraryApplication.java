package com.qhala.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = {"controllers", "models", "services", "repositories", "config"})
@EntityScan("models")
@EnableJpaRepositories(basePackages={"repositories"})
public class QhalaLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(QhalaLibraryApplication.class, args);
	}
	
	@Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
	  return new BCryptPasswordEncoder();
	 }

}

package com.qhala.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"controllers", "models", "services", "repositories", "config", "responses"})
@EntityScan("models")
@EnableJpaRepositories(basePackages={"repositories"})
@EnableSwagger2
public class QhalaLibraryApplication {


	  
	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/api/v1");
		SpringApplication.run(QhalaLibraryApplication.class, args);
	}
	@Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
	  return new BCryptPasswordEncoder();
	 }

}

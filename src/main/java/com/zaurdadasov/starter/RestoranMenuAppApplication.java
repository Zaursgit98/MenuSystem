package com.zaurdadasov.starter;

import org.springframework.boot.SpringApplication
;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@ComponentScan(basePackages = "com.zaurdadasov")
@EntityScan(basePackages = "com.zaurdadasov")
@EnableJpaRepositories(basePackages = "com.zaurdadasov")
@EnableConfigurationProperties
@SpringBootApplication
public class RestoranMenuAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestoranMenuAppApplication.class, args);
	}

}

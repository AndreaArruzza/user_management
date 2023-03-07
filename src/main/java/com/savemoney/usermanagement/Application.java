package com.savemoney.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.savemoney", "com.global"})
@EnableJpaRepositories(basePackages = {"com.savemoney",  "com.global"})
@EntityScan(basePackages = {"com.savemoney",  "com.global"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

package com.phonelog.apllication.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@EnableAutoConfiguration
@EnableScheduling
@SpringBootApplication
public class PhoneCallProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneCallProjectApplication.class, args);
	}

}

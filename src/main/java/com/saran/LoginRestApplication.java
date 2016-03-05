package com.saran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.saran.config.LoginConfig;

@SpringBootApplication
@Import(LoginConfig.class)
public class LoginRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginRestApplication.class, args);
	}
}

package com.daniilbarsuk.webshopapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WebshopApiApplication {
	@Autowired
	private PasswordEncoder encoder;
	public static void main(String[] args) {
		SpringApplication.run(WebshopApiApplication.class, args);
	}
}

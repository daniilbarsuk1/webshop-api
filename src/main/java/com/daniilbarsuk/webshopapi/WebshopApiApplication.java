package com.daniilbarsuk.webshopapi;

import com.daniilbarsuk.webshopapi.dto.UserDto;
import com.daniilbarsuk.webshopapi.facade.WebShopFacade;
import com.daniilbarsuk.webshopapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WebshopApiApplication {
	@Autowired
	private WebShopFacade facade;
	public static void main(String[] args) {
		SpringApplication.run(WebshopApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner createAdmin(){
		return args -> {
			String username = "admin", password = "admin";
			if(!facade.existsUser(username))
				facade.createUser(new UserDto(username, password));
		};
	}
}

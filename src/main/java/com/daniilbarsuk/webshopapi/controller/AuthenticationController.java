package com.daniilbarsuk.webshopapi.controller;

import com.daniilbarsuk.webshopapi.dto.UserDto;
import com.daniilbarsuk.webshopapi.facade.WebShopFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	@Autowired
	WebShopFacade facade;
	@PostMapping ("/signup")
	public ResponseEntity<UserDto> signup(@RequestBody UserDto userDto){
		try {
			UserDto user = facade.createUser(userDto);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}

package com.daniilbarsuk.webshopapi.controller;

import com.daniilbarsuk.webshopapi.dto.UserDto;
import com.daniilbarsuk.webshopapi.facade.WebShopFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	WebShopFacade facade;
	@GetMapping
	public ResponseEntity<UserDto> get(){
		try {
			UserDto user = facade.getCurrentUser();
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping
	public ResponseEntity<UserDto> delete(){
		try{
			facade.deleteCurrentUser();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}

package com.daniilbarsuk.webshopapi.controller;

import com.daniilbarsuk.webshopapi.dto.BasketDto;
import com.daniilbarsuk.webshopapi.facade.WebShopFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/basket")
public class BasketController {
	@Autowired
	WebShopFacade facade;
	@GetMapping
	public ResponseEntity<BasketDto> get(){
		try {
			return new ResponseEntity<>(facade.getBasket(), HttpStatus.OK);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/items/{item_id}")
	public ResponseEntity<BasketDto> addItemToBasket(@PathVariable("item_id") Integer itemId){
		try {
			return new ResponseEntity<>(facade.addItemToBasket(itemId), HttpStatus.OK);
		}
		catch (NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/items/{item_id}")
	public ResponseEntity<?> deleteItemFromBasket(@PathVariable("item_id") Integer itemId){
		try {
			BasketDto basket = facade.deleteItemFromBasket(itemId);
			return new ResponseEntity<>(basket, HttpStatus.OK);
		}
		catch (IllegalArgumentException e){
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}

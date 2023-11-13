package com.daniilbarsuk.webshopapi.controller;

import com.daniilbarsuk.webshopapi.dto.BasketDto;
import com.daniilbarsuk.webshopapi.dto.ItemDto;
import com.daniilbarsuk.webshopapi.facade.WebShopFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/baskets")
public class BasketController {
	@Autowired
	WebShopFacade facade;
	@PostMapping
	public ResponseEntity<BasketDto> create(){
		return new ResponseEntity<>(facade.createBasket(), HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<BasketDto> get(@PathVariable Integer id){
		try {
			return new ResponseEntity<>(facade.getBasket(id), HttpStatus.OK);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/{basket_id}/items/{item_id}")
	public ResponseEntity<BasketDto> addItem(@PathVariable("basket_id") Integer basketId,
	                     @PathVariable("item_id") Integer itemId){
		try {
			return new ResponseEntity<>(facade.addItem(basketId, itemId), HttpStatus.OK);
		}
		catch (NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

package com.daniilbarsuk.webshopapi.controller;

import com.daniilbarsuk.webshopapi.dto.ItemDto;
import com.daniilbarsuk.webshopapi.facade.WebShopFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	WebShopFacade facade;
	@PostMapping
	public ResponseEntity<ItemDto> create(String name, int price) {
		return new ResponseEntity<>(facade.createItem(name, price), HttpStatus.CREATED);
	}
	@GetMapping ("/{item_id}")
	public  ResponseEntity<ItemDto> get(@PathVariable("item_id") Integer id){
		try {
			ItemDto item = facade.getItem(id);
			return new ResponseEntity<>(item, HttpStatus.OK);
		}
		catch (NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

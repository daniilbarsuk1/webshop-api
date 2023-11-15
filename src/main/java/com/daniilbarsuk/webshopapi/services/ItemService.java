package com.daniilbarsuk.webshopapi.services;

import com.daniilbarsuk.webshopapi.entities.Item;

import java.util.NoSuchElementException;

public interface ItemService {
	Item create(String name, Integer price);
	Item get(Integer id);
	void delete(Integer id);
}

package com.daniilbarsuk.webshopapi.services;

import com.daniilbarsuk.webshopapi.entities.Item;

import java.util.NoSuchElementException;

public interface ItemService {
	Item create(String name, int price);
	Item get(Integer id);
	void delete(Integer id);
}

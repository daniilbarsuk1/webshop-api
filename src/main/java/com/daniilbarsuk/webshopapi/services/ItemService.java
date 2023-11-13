package com.daniilbarsuk.webshopapi.services;

import com.daniilbarsuk.webshopapi.entities.Item;

public interface ItemService {
	public Item create(String name, int price);
	public Item get(Integer id);

}

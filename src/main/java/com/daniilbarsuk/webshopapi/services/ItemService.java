package com.daniilbarsuk.webshopapi.services;

import com.daniilbarsuk.webshopapi.entities.Item;

public interface ItemService {
	Item create(String name, int price);
	Item get(Integer id);

}

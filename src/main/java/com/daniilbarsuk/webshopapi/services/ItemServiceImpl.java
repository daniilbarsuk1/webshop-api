package com.daniilbarsuk.webshopapi.services;

import com.daniilbarsuk.webshopapi.entities.Item;
import com.daniilbarsuk.webshopapi.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemRepository itemRepository;
	public Item create (String name, int price) {
		Item item = new Item(name, price);
		return itemRepository.save(item);
	}

	public Item get (Integer id) {
		return itemRepository.findById(id).orElseThrow();
	}
}

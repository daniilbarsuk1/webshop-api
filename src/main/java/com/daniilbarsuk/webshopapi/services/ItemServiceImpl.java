package com.daniilbarsuk.webshopapi.services;

import com.daniilbarsuk.webshopapi.entities.Item;
import com.daniilbarsuk.webshopapi.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemRepository itemRepository;
	public Item create (String name, int price) {
		Item item = new Item(name, price);
		return itemRepository.save(item);
	}

	public Item get (Integer id) throws NoSuchElementException {
		return itemRepository.findById(id).orElseThrow();
	}

	public void delete (Integer id) throws IllegalArgumentException {
		itemRepository.deleteById(id);
	}
}

package com.daniilbarsuk.webshopapi.services;

import com.daniilbarsuk.webshopapi.entities.Basket;
import com.daniilbarsuk.webshopapi.entities.Item;
import com.daniilbarsuk.webshopapi.repositories.BasketRepository;
import com.daniilbarsuk.webshopapi.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {
	@Autowired
	private BasketRepository basketRepository;
	@Autowired
	private ItemRepository itemRepository;
	public Basket create(){
		Basket basket = new Basket();
		return basketRepository.save(basket);
	}
	public Basket get(Integer id) {
		return basketRepository.findById(id).orElseThrow();
	}
	public Basket addItemToBasket(Integer basketId, Integer itemId){
		Basket basket = basketRepository.findById(basketId).orElseThrow();
		Item item = itemRepository.findById(itemId).orElseThrow();
		basket.getItems().add(item);
		return basketRepository.save(basket);
	}
	public Basket deleteItemFromBasket(Integer basketId, Integer itemId){
		Basket basket = basketRepository.findById(basketId).orElseThrow();
		Item item = itemRepository.findById(itemId).orElseThrow();
		basket.getItems().remove(item);
		return basketRepository.save(basket);
	}
	public void delete(Integer id){
		basketRepository.deleteById(id);
	}
}

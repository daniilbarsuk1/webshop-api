package com.daniilbarsuk.webshopapi.facade;

import com.daniilbarsuk.webshopapi.dto.BasketDto;
import com.daniilbarsuk.webshopapi.dto.ItemDto;
import com.daniilbarsuk.webshopapi.entities.Basket;
import com.daniilbarsuk.webshopapi.entities.Item;
import com.daniilbarsuk.webshopapi.mapper.WebShopMapper;
import com.daniilbarsuk.webshopapi.services.BasketService;
import com.daniilbarsuk.webshopapi.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class WebShopFacadeImpl implements WebShopFacade{
	@Autowired
	BasketService basketService;
	@Autowired
	ItemService itemService;
	@Autowired
	WebShopMapper mapper;
	public ItemDto createItem(String name, int price){
		Item item = itemService.create(name, price);
		return mapper.toItemDto(item);
	}

	public BasketDto createBasket () {
		Basket basket = basketService.create();
		return mapper.toBasketDto(basket);
	}
	public ItemDto getItem(Integer id) {
		Item item = itemService.get(id);
		return mapper.toItemDto(item);
	}
	public BasketDto getBasket (Integer id) {
		Basket basket = basketService.get(id);
		return mapper.toBasketDto(basket);
	}
	public BasketDto addItem(Integer basketId, Integer itemId){
		Basket basket = basketService.add(basketId, itemId);
		return mapper.toBasketDto(basket);
	}
}

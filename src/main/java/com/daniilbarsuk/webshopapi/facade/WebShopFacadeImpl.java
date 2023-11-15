package com.daniilbarsuk.webshopapi.facade;

import com.daniilbarsuk.webshopapi.dto.BasketDto;
import com.daniilbarsuk.webshopapi.dto.ItemDetailsDto;
import com.daniilbarsuk.webshopapi.dto.ItemDto;
import com.daniilbarsuk.webshopapi.entities.Basket;
import com.daniilbarsuk.webshopapi.entities.Item;
import com.daniilbarsuk.webshopapi.mapper.WebShopMapper;
import com.daniilbarsuk.webshopapi.services.BasketService;
import com.daniilbarsuk.webshopapi.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class WebShopFacadeImpl implements WebShopFacade{
	@Autowired
	BasketService basketService;
	@Autowired
	ItemService itemService;
	@Autowired
	WebShopMapper mapper;
	public ItemDto createItem(ItemDetailsDto itemDetailsDto){
		Item item = itemService.create(itemDetailsDto.name(), itemDetailsDto.price());
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
	public BasketDto addItemToBasket(Integer basketId, Integer itemId){
		Basket basket = basketService.addItemToBasket(basketId, itemId);
		return mapper.toBasketDto(basket);
	}
	public BasketDto deleteItemFromBasket(Integer basketId, Integer itemId){
		Basket basket = basketService.deleteItemFromBasket(basketId, itemId);
		return mapper.toBasketDto(basket);
	}
	public void deleteBasket(Integer id){
		basketService.delete(id);
	}
	public void deleteItem(Integer id){
		itemService.delete(id);
	}

}

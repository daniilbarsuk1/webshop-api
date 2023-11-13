package com.daniilbarsuk.webshopapi.facade;

import com.daniilbarsuk.webshopapi.dto.BasketDto;
import com.daniilbarsuk.webshopapi.dto.ItemDto;

import java.util.NoSuchElementException;

public interface WebShopFacade {
	ItemDto createItem(String name, int price);
	BasketDto createBasket ();
	ItemDto getItem(Integer id);
	BasketDto getBasket(Integer id);
	BasketDto addItem(Integer basketId, Integer itemId);
}

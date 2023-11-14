package com.daniilbarsuk.webshopapi.facade;

import com.daniilbarsuk.webshopapi.dto.BasketDto;
import com.daniilbarsuk.webshopapi.dto.ItemDto;

public interface WebShopFacade {
	ItemDto createItem(String name, int price);
	BasketDto createBasket ();
	ItemDto getItem(Integer id);
	BasketDto getBasket(Integer id);
	BasketDto addItemToBasket(Integer basketId, Integer itemId);
	void deleteBasket(Integer id);
	void deleteItem(Integer id);
	BasketDto deleteItemFromBasket(Integer basketId, Integer itemId);
}

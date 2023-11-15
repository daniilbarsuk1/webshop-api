package com.daniilbarsuk.webshopapi.facade;

import com.daniilbarsuk.webshopapi.dto.BasketDto;
import com.daniilbarsuk.webshopapi.dto.ItemDetailsDto;
import com.daniilbarsuk.webshopapi.dto.ItemDto;

public interface WebShopFacade {
	ItemDto createItem(ItemDetailsDto itemDetailsDto);
	BasketDto createBasket ();
	ItemDto getItem(Integer id);
	BasketDto getBasket(Integer id);
	BasketDto addItemToBasket(Integer basketId, Integer itemId);
	void deleteBasket(Integer id);
	void deleteItem(Integer id);
	BasketDto deleteItemFromBasket(Integer basketId, Integer itemId);
}

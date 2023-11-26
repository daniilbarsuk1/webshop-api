package com.daniilbarsuk.webshopapi.facade;

import com.daniilbarsuk.webshopapi.dto.BasketDto;
import com.daniilbarsuk.webshopapi.dto.ItemDetailsDto;
import com.daniilbarsuk.webshopapi.dto.ItemDto;
import com.daniilbarsuk.webshopapi.dto.UserDto;

public interface WebShopFacade {
	ItemDto createItem(ItemDetailsDto itemDetailsDto);
	UserDto createUser(UserDto userDto);
	ItemDto getItem(Integer id);
	BasketDto getBasket();
	UserDto getCurrentUser();
	BasketDto addItemToBasket(Integer itemId);
	BasketDto deleteItemFromBasket(Integer itemId);
	void deleteCurrentUser ();
	Boolean existsUser(String username);
}

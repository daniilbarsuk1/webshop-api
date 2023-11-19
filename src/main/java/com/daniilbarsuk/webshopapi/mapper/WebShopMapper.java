package com.daniilbarsuk.webshopapi.mapper;

import com.daniilbarsuk.webshopapi.dto.BasketDto;
import com.daniilbarsuk.webshopapi.dto.ItemDto;
import com.daniilbarsuk.webshopapi.dto.UserDto;
import com.daniilbarsuk.webshopapi.entities.Basket;
import com.daniilbarsuk.webshopapi.entities.Item;
import com.daniilbarsuk.webshopapi.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WebShopMapper {
	ItemDto toItemDto (Item item);
	BasketDto toBasketDto(Basket basket);
	UserDto toUserDto(User user);
}


package com.daniilbarsuk.webshopapi.facade;

import com.daniilbarsuk.webshopapi.dto.BasketDto;
import com.daniilbarsuk.webshopapi.dto.ItemDetailsDto;
import com.daniilbarsuk.webshopapi.dto.ItemDto;
import com.daniilbarsuk.webshopapi.dto.UserDto;
import com.daniilbarsuk.webshopapi.entities.Basket;
import com.daniilbarsuk.webshopapi.entities.Item;
import com.daniilbarsuk.webshopapi.entities.User;
import com.daniilbarsuk.webshopapi.mapper.WebShopMapper;
import com.daniilbarsuk.webshopapi.services.BasketService;
import com.daniilbarsuk.webshopapi.services.ItemService;
import com.daniilbarsuk.webshopapi.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class WebShopFacadeImpl implements WebShopFacade{
	@Autowired
	private BasketService basketService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	WebShopMapper mapper;
	public ItemDto createItem(ItemDetailsDto itemDetailsDto){
		Item item = itemService.create(itemDetailsDto.name(), itemDetailsDto.price());
		return mapper.toItemDto(item);
	}

	public UserDto createUser (UserDto userDto) {
		User user = userService.create(userDto.username(), encoder.encode(userDto.password()));
		return mapper.toUserDto(user);
	}

	public ItemDto getItem(Integer id) {
		Item item = itemService.get(id);
		return mapper.toItemDto(item);
	}
	public BasketDto getBasket () {
		User user = userService.getCurrentUser();
		Integer basketId = user.getBasket().getId();
		Basket basket = basketService.get(basketId);
		return mapper.toBasketDto(basket);
	}
	public UserDto getCurrentUser(){
		User user = userService.getCurrentUser();
		return mapper.toUserDto(user);
	}

	public BasketDto addItemToBasket(Integer itemId){
		User user = userService.getCurrentUser();
		Integer basketId = user.getBasket().getId();
		Basket basket = basketService.addItemToBasket(basketId, itemId);
		return mapper.toBasketDto(basket);
	}

	public BasketDto deleteItemFromBasket(Integer itemId){
		User user = userService.getCurrentUser();
		Integer basketId = user.getBasket().getId();
		Basket basket = basketService.deleteItemFromBasket(basketId, itemId);
		return mapper.toBasketDto(basket);
	}

	public void deleteCurrentUser () {
		User user = userService.getCurrentUser();
		Integer basketId = user.getBasket().getId();
		basketService.delete(basketId);
		userService.delete(user.getId());
	}


}

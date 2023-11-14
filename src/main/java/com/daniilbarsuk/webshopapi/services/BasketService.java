package com.daniilbarsuk.webshopapi.services;

import com.daniilbarsuk.webshopapi.entities.Basket;

import java.util.NoSuchElementException;

public interface BasketService {
	Basket create();
	Basket get(Integer id);
	Basket addItemToBasket(Integer basketId, Integer itemId);
	Basket deleteItemFromBasket(Integer basketId, Integer itemId);
	void delete(Integer id);
}

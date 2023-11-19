package com.daniilbarsuk.webshopapi.services;

import com.daniilbarsuk.webshopapi.entities.Basket;

public interface BasketService {
	Basket get(Integer id);
	Basket addItemToBasket(Integer basketId, Integer itemId);
	Basket deleteItemFromBasket(Integer basketId, Integer itemId);
	void delete(Integer id);
}

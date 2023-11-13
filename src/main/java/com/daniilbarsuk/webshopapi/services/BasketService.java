package com.daniilbarsuk.webshopapi.services;

import com.daniilbarsuk.webshopapi.entities.Basket;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.NoSuchElementException;

public interface BasketService {
	Basket create();
	Basket get(Integer id) throws NoSuchElementException;
	Basket add(Integer basketId, Integer itemId) throws NoSuchElementException;
}

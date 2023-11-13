package com.daniilbarsuk.webshopapi.repositories;

import com.daniilbarsuk.webshopapi.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Integer> {
}

package com.daniilbarsuk.webshopapi.repositories;

import com.daniilbarsuk.webshopapi.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}

package com.daniilbarsuk.webshopapi.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Basket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
		joinColumns = @JoinColumn(name="basket_id"),
		inverseJoinColumns = @JoinColumn(name="item_id")
	)
	private Set<Item> items;

	public Integer getId () {
		return id;
	}

	public Set<Item> getItems () {
		return items;
	}

	public void setItems (Set<Item> items) {
		this.items = items;
	}

	public Basket(){
		this.items = new HashSet<>();
	}
}

package com.daniilbarsuk.webshopapi.entities;

import jakarta.persistence.*;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private int price;
	public Item(){}

	public Item (String name, int price) {
		this.name = name;
		this.price = price;
	}

	public Integer getId () {
		return id;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public int getPrice () {
		return price;
	}

	public void setPrice (int price) {
		this.price = price;
	}
}

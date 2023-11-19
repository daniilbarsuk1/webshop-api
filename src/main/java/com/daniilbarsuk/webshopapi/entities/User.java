package com.daniilbarsuk.webshopapi.entities;


import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table (name = "users")
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToOne(fetch = FetchType.EAGER)
	private Basket basket;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	public User(){}
	public User (String username, String password, Basket basket) {
		this.username = username;
		this.password = password;
		this.basket = basket;
	}
	public Integer getId(){
		return id;
	}
	public Basket getBasket(){
		return basket;
	}

	public Collection<? extends GrantedAuthority> getAuthorities () {
		return null;
	}

	public String getPassword () {
		return password;
	}

	public String getUsername () {
		return username;
	}

	public boolean isAccountNonExpired () {
		return true;
	}

	public boolean isAccountNonLocked () {
		return true;
	}

	public boolean isCredentialsNonExpired () {
		return true;
	}

	public boolean isEnabled () {
		return true;
	}
}

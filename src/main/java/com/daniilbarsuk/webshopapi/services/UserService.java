package com.daniilbarsuk.webshopapi.services;

import com.daniilbarsuk.webshopapi.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	User create(String username, String password);
	User getCurrentUser();
	void delete(Integer id);
}

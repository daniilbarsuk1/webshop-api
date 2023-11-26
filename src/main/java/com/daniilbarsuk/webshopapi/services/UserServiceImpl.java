package com.daniilbarsuk.webshopapi.services;

import com.daniilbarsuk.webshopapi.entities.Basket;
import com.daniilbarsuk.webshopapi.entities.User;
import com.daniilbarsuk.webshopapi.repositories.BasketRepository;
import com.daniilbarsuk.webshopapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BasketRepository basketRepository;
	public User loadUserByUsername (String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(username);

		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		return user;
	}
	public User create(String username, String password){
		Basket basket = basketRepository.save(new Basket());
		User user = new User(username, password, basket);
		return userRepository.save(user);
	}

	public User getCurrentUser () {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return (User) authentication.getPrincipal();
	}
	public void delete(Integer id){
		userRepository.deleteById(id);
	}

	public Boolean exists (String username) {
		return userRepository.existsByUsername(username);
	}
}

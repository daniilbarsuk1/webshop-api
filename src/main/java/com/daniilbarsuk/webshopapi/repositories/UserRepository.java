package com.daniilbarsuk.webshopapi.repositories;

import com.daniilbarsuk.webshopapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByUsername(String username);
	Boolean existsByUsername(String username);
}

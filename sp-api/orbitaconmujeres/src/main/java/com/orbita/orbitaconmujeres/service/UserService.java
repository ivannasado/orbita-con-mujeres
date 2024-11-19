package com.orbita.orbitaconmujeres.service;

import java.util.Set;

import com.orbita.orbitaconmujeres.model.User;


public interface UserService {

	User createUser(User user);
	User getUserById(Long id);
	User getUserByEmail(String email);
	Set<User> getAllUsers(boolean isActive);
	User updateUser(User user, Long id);
	void deleteUser(Long id);
	
}

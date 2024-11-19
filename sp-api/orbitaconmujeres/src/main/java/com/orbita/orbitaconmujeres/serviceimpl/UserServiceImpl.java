package com.orbita.orbitaconmujeres.serviceimpl;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.orbita.orbitaconmujeres.model.User;
import com.orbita.orbitaconmujeres.repository.UserRepository;
import com.orbita.orbitaconmujeres.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
		if( optionalUser.isPresent()) {
			throw new IllegalStateException("User already exist with email " + user.getEmail());
		}
		// TODO Verificar si los atributos son válidos
		user.setActive(true); // activar cliente
		user.setIdUser(null); // forzar la creación del cliente		
		User newUser = userRepository.save( user );
		return newUser;
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if( optionalUser.isEmpty()) {
			// Lanzar una excepción.
			throw new IllegalStateException("User does not exist with id " + id);
		}
		User existingUser = optionalUser.get();
		return existingUser;
	}

	@Override
	public User getUserByEmail(String email) {
		Optional<User> optionalUser = userRepository.findByEmail(email);
		if( optionalUser.isEmpty()) {
			throw new IllegalStateException("User does not exist with email " + email);
		}
		return optionalUser.get();
	}


	@Override
	public Set<User> getAllUsers(boolean isActive) {
		Set<User> user;
		if( isActive ) {
			user = userRepository.findAllByActiveTrue();
		} else {
			user = userRepository.findAllByActiveFalse();
		}
		return user;
	}

	@Override
	public User updateUser(User user, Long id) {
		// TODO verificar los nuevos atributos a cambiar
		User existingUser = getUserById(id);
		existingUser.setFirstName( user.getFirstName() );
		existingUser.setLastName( user.getLastName() );
		// ID y email no se permite modificar
		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(Long id) {
		User existingUser = getUserById(id);
		// customerRepository.delete(existingCustomer);
		existingUser.setActive(false); // desactivar al usuario
		userRepository.save(existingUser);
	}

}

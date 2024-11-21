package com.orbita.orbitaconmujeres.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.orbita.orbitaconmujeres.model.User;
import com.orbita.orbitaconmujeres.repository.UserRepository;
import com.orbita.orbitaconmujeres.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	UserRepository customerRepository;
		
	public LoginServiceImpl(UserRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public User loginCustomer(User customer) {
		String email = customer.getEmail();
		Optional<User > optionalCustomer = customerRepository.findByEmail(email);
		if( optionalCustomer.isPresent() ) {
			User existingCustomer = optionalCustomer.get();
			if( existingCustomer.getPassword().equals( customer.getPassword()) ) {
				return existingCustomer;
			}
		}
		throw new IllegalStateException("Incorrect e-mail or password");				
	}

}

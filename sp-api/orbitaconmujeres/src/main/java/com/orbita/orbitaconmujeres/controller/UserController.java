package com.orbita.orbitaconmujeres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orbita.orbitaconmujeres.model.User;
import com.orbita.orbitaconmujeres.repository.UserRepository;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {


	    final UserRepository userRepository;
		


	    public UserController (@Autowired UserRepository userRepository )
	    {
	        this.userRepository = userRepository;
	    }

	    @GetMapping
	    public Iterable<User> getUsers(){
	        return userRepository.findAll();
	    }
	}
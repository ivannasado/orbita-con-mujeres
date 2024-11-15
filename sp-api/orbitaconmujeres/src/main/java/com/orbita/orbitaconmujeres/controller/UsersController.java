package com.orbita.orbitaconmujeres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orbita.orbitaconmujeres.model.Users;
import com.orbita.orbitaconmujeres.repository.UsersRepository;


@RestController
@RequestMapping("/users")
public class UsersController {


	    final UsersRepository usersRepository;
		


	    public UsersController (@Autowired UsersRepository usersRepository )
	    {
	        this.usersRepository = usersRepository;
	    }

	    @GetMapping
	    public Iterable<Users> getUsers(){
	        return usersRepository.findAll();
	    }
	}
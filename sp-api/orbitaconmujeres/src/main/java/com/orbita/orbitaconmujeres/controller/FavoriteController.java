package com.orbita.orbitaconmujeres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orbita.orbitaconmujeres.model.Favorite;
import com.orbita.orbitaconmujeres.repository.FavoriteRepository;



@RestController
@RequestMapping("/favorite")
public class FavoriteController {


	    final FavoriteRepository favoriteRepository;
		


	    public FavoriteController (@Autowired FavoriteRepository favoriteRepository )
	    {
	        this.favoriteRepository = favoriteRepository;
	    }

	    @GetMapping
	    public Iterable<Favorite> getFavorite(){
	        return favoriteRepository.findAll();
	    }
	}

package com.orbita.orbitaconmujeres.service;

import com.orbita.orbitaconmujeres.model.Favorite;

public interface FavoriteService {
	
	Favorite getFavoriteById(Long id);
	Favorite updateFavorite(Favorite favorite, Long id);
	void deleteFavorite(Long id);
	Favorite createFavorite(Favorite favorite);

}

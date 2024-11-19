package com.orbita.orbitaconmujeres.serviceimpl;



import java.util.Optional;
import com.orbita.orbitaconmujeres.model.Favorite;
import com.orbita.orbitaconmujeres.repository.FavoriteRepository;
import com.orbita.orbitaconmujeres.service.FavoriteService;



public class FavoriteServiceImpl implements FavoriteService {

	FavoriteRepository favoriteRepository;
	
	@Override
	public Favorite createFavorite(Favorite favorite) {
		// TODO Verificar si los atributos son válidos
		favorite.setActive(true); 
		favorite.setIdFavorites(null); 
		Favorite newFavorite = favoriteRepository.save( favorite );
		return newFavorite;
	}
	
	@Override
	public Favorite getFavoriteById(Long id) {
			Optional<Favorite> optionalFavorite = favoriteRepository.findByIdFavorites(id);
			if( optionalFavorite.isEmpty()) {
				throw new IllegalStateException("Favorite does not exist with id " + id);
			}
			Favorite existingFavorite = optionalFavorite.get();
			return existingFavorite;
		}

	
	@Override
	public Favorite updateFavorite(Favorite favorite, Long id) {
		// TODO Auto-generated method stub
		Favorite existingFavorite = getFavoriteById(id);
		existingFavorite.setIdFavorites( favorite.getIdFavorites() );
			
		return favoriteRepository.save(existingFavorite);
	}
	
	@Override
	public void deleteFavorite(Long id) {
		Favorite existingFavorite = getFavoriteById(id);
		existingFavorite.setActive(false); // desactivar al usuario
		favoriteRepository.save(existingFavorite);
	}

}

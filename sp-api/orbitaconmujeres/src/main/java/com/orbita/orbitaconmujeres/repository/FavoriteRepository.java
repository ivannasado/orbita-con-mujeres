package com.orbita.orbitaconmujeres.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.orbita.orbitaconmujeres.model.Favorite;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "favorite", path = "favorite")
public interface FavoriteRepository extends CrudRepository<Favorite, Long> {

	Optional<Favorite> findByIdFavorites(Long id);
	

}

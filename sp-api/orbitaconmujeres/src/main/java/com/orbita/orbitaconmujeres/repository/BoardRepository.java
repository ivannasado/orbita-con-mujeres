package com.orbita.orbitaconmujeres.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.orbita.orbitaconmujeres.model.Board;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "board", path = "board")
public interface BoardRepository extends CrudRepository<Board, Long> {
	

}

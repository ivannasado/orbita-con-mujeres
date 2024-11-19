package com.orbita.orbitaconmujeres.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.orbita.orbitaconmujeres.model.Post;


@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "post", path = "post")
public interface PostRepository extends CrudRepository<Post, Long> {
	
}

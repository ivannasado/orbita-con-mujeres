package com.orbita.orbitaconmujeres.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.orbita.orbitaconmujeres.model.Tag;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "tag", path = "tag")
public interface TagRepository extends CrudRepository<Tag, Long> {

	Set<Tag> findAllByActiveTrue();
	Set<Tag> findAllByActiveFalse();

}

package com.orbita.orbitaconmujeres.repository;


import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.orbita.orbitaconmujeres.model.Profile;


@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "profile", path = "profile")
public interface ProfileRepository extends CrudRepository<Profile, Long> {
   
	Set<Profile> findAllByActiveTrue();
	Set<Profile> findAllByActiveFalse();

}
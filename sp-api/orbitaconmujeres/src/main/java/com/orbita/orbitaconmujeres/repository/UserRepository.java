package com.orbita.orbitaconmujeres.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.orbita.orbitaconmujeres.model.User;


@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "user", path = "user")

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(String email);
	List<User> findByLastName(String lastname);
	List<User> findByFirstName(String firstname);
	Set<User> findAllByActiveTrue();
	Set<User> findAllByActiveFalse();
}
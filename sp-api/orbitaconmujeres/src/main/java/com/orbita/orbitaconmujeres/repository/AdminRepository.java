package com.orbita.orbitaconmujeres.repository;


import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.orbita.orbitaconmujeres.model.Admin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "admin", path = "admin")
	
public interface AdminRepository extends CrudRepository<Admin, Long> {

	Optional<Admin> findByName(String name);
		

}

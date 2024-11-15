package com.orbita.orbitaconmujeres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Favorite {
	
	// Indica que el atributo será la clave primaria
	@Id 
	// Indica como se generará automáticamente las claves primarias
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFavorites;
	
	
	protected Favorite() {}

	public Long getId() {
		return idFavorites;
	}

	public void setId(Long idFavorites) {
		this.idFavorites = idFavorites;
	}


}
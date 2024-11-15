package com.orbita.orbitaconmujeres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tag {
	
	// Indica que el atributo será la clave primaria
	@Id 
	// Indica como se generará automáticamente las claves primarias
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long idTag;
	private String categories;
	
	protected Tag() {}

	public Long getId() {
		return idTag;
	}

	public void setId(Long idTag) {
		this.idTag = idTag;
	}

	public String getCategories() {
		return categories;
	}

	public void setName(String categories) {
		this.categories = categories;
	}


	

}

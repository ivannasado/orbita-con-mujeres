package com.orbita.orbitaconmujeres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {
	
	// Indica que el atributo será la clave primaria
	@Id 
	// Indica como se generará automáticamente las claves primarias
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long idTag;
	private String categories;
	private boolean active;
	
	protected Tag() {}

	public Long getIdTag() {
		return idTag;
	}

	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

}

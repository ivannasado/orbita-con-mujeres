package com.orbita.orbitaconmujeres.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "board")
public class Board {
	
	@Id 
	// Indica como se generará automáticamente las claves primarias
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBoard;
	@Column(name = "description", columnDefinition = "VARCHAR(200)")
	private String description;
	
	@Column(name = "image", columnDefinition = "VARCHAR(200)")
	private String image;
	private LocalDate creationDate;
	
	protected Board() {}
	
	public Long getId() {
		return idBoard;
	}

	public void setId(Long idBoard) {
		this.idBoard = idBoard;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public LocalDate getDate() {
		return creationDate;
	}

	public void setDate(LocalDate creation_date) {
		this.creationDate = creation_date;
	}

	
	
	
	

}

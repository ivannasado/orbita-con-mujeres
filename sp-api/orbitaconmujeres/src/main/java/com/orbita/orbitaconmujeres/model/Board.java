package com.orbita.orbitaconmujeres.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private boolean active;
	@ManyToOne
	@JoinColumn(name = "fk_admin_id")
	private Admin admin;
	
	protected Board() {}

	public Long getIdBoard() {
		return idBoard;
	}

	public void setIdBoard(Long idBoard) {
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

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
	
	

}

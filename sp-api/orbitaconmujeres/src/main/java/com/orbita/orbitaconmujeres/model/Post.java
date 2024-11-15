package com.orbita.orbitaconmujeres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.lang.String;
import java.time.LocalDate;

@Entity
@Table(name = "post")
public class Post {
	
	
	// Indica que el atributo será la clave primaria
	@Id 
	// Indica como se generará automáticamente las claves primarias
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPost;
	private String content;
	
	private String image;
	private LocalDate creationDate;
	
	protected Post() {}

	public Long getId() {
		return idPost;
	}

	public void setId(Long idPost) {
		this.idPost = idPost;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	
	public void setDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	
	

}
package com.orbita.orbitaconmujeres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "fk_tag_id")
	private Tag tag;
	
	
	protected Post() {}

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
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

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public static void setActive(boolean active) {
	}

}
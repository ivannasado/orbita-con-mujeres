package com.orbita.orbitaconmujeres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Favorite {
	
	// Indica que el atributo será la clave primaria
	@Id 
	// Indica como se generará automáticamente las claves primarias
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFavorites;
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "fk_post_id")
	private Post Post;
	
	
	protected Favorite() {}


	public Long getIdFavorites() {
		return idFavorites;
	}


	public void setIdFavorites(Long idFavorites) {
		this.idFavorites = idFavorites;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Post getPost() {
		return Post;
	}


	public void setPost(Post post) {
		Post = post;
	}


	public void setActive(boolean b) {
		// TODO Auto-generated method stub
		
	}

	

	
}
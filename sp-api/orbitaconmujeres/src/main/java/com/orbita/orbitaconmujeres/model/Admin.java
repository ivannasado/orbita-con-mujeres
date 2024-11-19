package com.orbita.orbitaconmujeres.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idAdmins;
	 @Column(nullable = false, unique = true)
	 private String name;
	 private boolean active;
	 @OneToOne
	 @JoinColumn(name = "fk_user_id")
	 private User user;
	 
	 
	protected Admin() {}


	public Long getIdAdmins() {
		return idAdmins;
	}


	public void setIdAdmins(Long idAdmins) {
		this.idAdmins = idAdmins;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	

}
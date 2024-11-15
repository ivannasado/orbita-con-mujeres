package com.orbita.orbitaconmujeres.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idAdmins;
	 
     @Column(name = "name", columnDefinition = "VARCHAR(255)")
	 private String name;
	
	protected Admin() {}

	public Long getId() {
		return idAdmins;
	}

	public void setId(Long idAdmins) {
		this.idAdmins = idAdmins;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	



	
	
	

}
package com.orbita.orbitaconmujeres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {
	
	// Indica que el atributo será la clave primaria
	@Id 
	// Indica como se generará automáticamente las claves primarias
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProfile;
	private String aboutMe;
	
	private String profileImage;
	
	protected Profile() {}

	public Long getId() {
		return idProfile;
	}

	public void setId(Long idProfile) {
		this.idProfile = idProfile;
	}

	public String getImage() {
		return profileImage;
	}

	public void setImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}


	
	
	
	

}

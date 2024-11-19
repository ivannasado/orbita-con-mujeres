package com.orbita.orbitaconmujeres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	private boolean active;
	
	@OneToOne
	@JoinColumn(name = "fk_user_id")
	private User user;
	protected Profile() {}

	public Long getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Long idProfile) {
		this.idProfile = idProfile;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public void setId(Object object) {
		// TODO Auto-generated method stub
		
	}

	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

	

	

}

package com.orbita.orbitaconmujeres.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	// Indica que el atributo será la clave primaria
	@Id 
	// Indica como se generará automáticamente las claves primarias
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	
	@Column(name="user_name", length=100, nullable=false)
	private String userName;
	@Column(name="first_name", length=100, nullable=false)
	private String firstName;
	@Column(name="last_name", length=100, nullable=false)
	private String lastName;
	@Column(name="email", length=100, nullable=false)
	private String email;
	@Column(name="password", length=100, nullable=false)
	private String password;
	private Long telephone;
	private LocalDate creationDate;
	private boolean active;
	
	
	
	
	protected User() {}

	public User(String firstName, String lastName) {		
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User(String firstName, String lastName, String email) {
		this(firstName, lastName);
		this.email = email;
	}
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	
}
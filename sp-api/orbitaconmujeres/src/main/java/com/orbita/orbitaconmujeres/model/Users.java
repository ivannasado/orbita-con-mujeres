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
public class Users {
	
	// Indica que el atributo será la clave primaria
	@Id 
	// Indica como se generará automáticamente las claves primarias
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUsers;
	
	@Column(name="users_name", length=100, nullable=false)
	private String usersName;
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
	
	
	
	protected Users() {}

	public Long getId() {
		return idUsers;
	}

	public void setId(Long idUsers) {
		this.idUsers = idUsers;
	}

	public String getUserName() {
		return usersName;
	}

	public void setUserName(String usersName) {
		this.usersName = usersName;
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
	
	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
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

	public LocalDate getDate() {
		return creationDate;
	}

	public void setDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	
	
	

}
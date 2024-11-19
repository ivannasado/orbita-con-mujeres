package com.orbita.orbitaconmujeres.service;

import com.orbita.orbitaconmujeres.model.Admin;

public interface AdminService
{

	Admin createAdmin(Admin admin);
	Admin getAdminById(Long id);
	Admin updateAdmin(Admin admin, Long id);
	void deleteAdmin(Long id);
}
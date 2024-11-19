package com.orbita.orbitaconmujeres.serviceimpl;


import java.util.Optional;
import org.springframework.stereotype.Service;

import com.orbita.orbitaconmujeres.model.Admin;
import com.orbita.orbitaconmujeres.repository.AdminRepository;
import com.orbita.orbitaconmujeres.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	AdminRepository adminRepository;

	public AdminServiceImpl(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	@Override
	public Admin createAdmin(Admin admin) {
		Optional<Admin> optionalAdmin = adminRepository.findByName(admin.getName());
		if( optionalAdmin.isPresent()) {
			throw new IllegalStateException("Admin already exist with: " + admin.getName());
		}
		// TODO Verificar si los atributos son válidos
		admin.setActive(true); 
		admin.setIdAdmins(null); 
		Admin newAdmin = adminRepository.save( admin );
		return newAdmin;
	}

	@Override
	public Admin getAdminById(Long id) {
		Optional<Admin> optionalAdmin = adminRepository.findById(id);
		if( optionalAdmin.isEmpty()) {
			throw new IllegalStateException("Admin does not exist with id " + id);
		}
		Admin existingAdmin = optionalAdmin.get();
		return existingAdmin;
	}

	

	@Override
	public Admin updateAdmin(Admin admin, Long id) {
		// TODO verificar los nuevos atributos a cambiar
		Admin existingAdmin = getAdminById(id);
		existingAdmin.setName( admin.getName() );
	
		return adminRepository.save(existingAdmin);
	}

	@Override
	public void deleteAdmin(Long id) {
		Admin existingAdmin = getAdminById(id);
		existingAdmin.setActive(false); // desactivar al usuario
		adminRepository.save(existingAdmin);
	}

}


package com.orbita.orbitaconmujeres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orbita.orbitaconmujeres.model.Admin;
import com.orbita.orbitaconmujeres.repository.AdminRepository;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController{

    final AdminRepository adminRepository;
	


    public AdminController (@Autowired AdminRepository adminRepository )
    {
        this.adminRepository = adminRepository;
    }

    @GetMapping
    public Iterable<Admin> getAdmin(){
        return adminRepository.findAll();
    }
}
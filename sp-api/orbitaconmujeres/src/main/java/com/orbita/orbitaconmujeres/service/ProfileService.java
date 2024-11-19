package com.orbita.orbitaconmujeres.service;

import java.util.Set;

import com.orbita.orbitaconmujeres.model.Profile;



public interface ProfileService {

	Profile createProfile(Profile profile);
	Profile getProfileById(Long id);
	Set<Profile> getAllUsers(boolean isActive);
	Profile updateProfile(Profile profile, Long id);
	void deleteProfile(Long id);
	
}

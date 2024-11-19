package com.orbita.orbitaconmujeres.serviceimpl;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.orbita.orbitaconmujeres.model.Profile;
import com.orbita.orbitaconmujeres.repository.ProfileRepository;
import com.orbita.orbitaconmujeres.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

	ProfileRepository profileRepository;
	
	@Override
	public Profile createProfile(Profile profile) {
		Optional<Profile> optionalProfile = profileRepository.findById(profile.getIdProfile());
		if( optionalProfile.isPresent()) {
			throw new IllegalStateException("Profile already exist with: " + profile.getIdProfile());
		}
		// TODO Verificar si los atributos son válidos
		profile.setActive(true); 
		profile.setIdProfile(null); 
		Profile newProfile = profileRepository.save( profile );
		return newProfile;
	}

	@Override
	public Profile getProfileById(Long id) {
		Optional<Profile> optionalProfile = profileRepository.findById(id);
		if( optionalProfile.isEmpty()) {
			throw new IllegalStateException("Profile does not exist with id " + id);
		}
		Profile existingProfile = optionalProfile.get();
		return existingProfile;
	}

	@Override
	public Profile updateProfile(Profile profile, Long id) {
		// TODO verificar los nuevos atributos a cambiar
		Profile existingProfile = getProfileById(id);
				existingProfile.setId( profile.getIdProfile() );
			
				return profileRepository.save(existingProfile);
			}

	@Override
	public void deleteProfile(Long id) {
		Profile existingProfile = getProfileById(id);
		existingProfile.setActive(false); // desactivar al usuario
		profileRepository.save(existingProfile);
	}

	@Override
	public Set<Profile> getAllUsers(boolean isActive) {
		Set<Profile> profile;
		if( isActive ) {
			profile = profileRepository.findAllByActiveTrue();
		} else {
			profile = profileRepository.findAllByActiveFalse();
		}
		return profile;
	}

}

package com.travel.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.entity.Profile;
import com.travel.repository.ProfileRepository;


@Service
public class ProfileServiceImpl implements ProfileService{

	
	@Autowired
	ProfileRepository profileRepository;
	
	@Override
	public Profile addProfile(Profile profile) {
		// TODO Auto-generated method stub
        Profile savedProfile = profileRepository.save(profile);
		
		return savedProfile;
	}

	@Override
	public Profile getProfileByFullName(String fullName) throws Exception {
		// TODO Auto-generated method stub
		Profile outputProfile = profileRepository.getProfileByFullName(fullName);
		if (outputProfile == null) {
			throw new EntityNotFoundException(fullName + " Name is not listed in the database");
		} else {
			return outputProfile;
		}

}

	@Override
	public List<Profile> getAllProfiless() throws Exception {
		// TODO Auto-generated method stub
		List<Profile> allProfiles = profileRepository.findAll();
		return allProfiles;

	}

	@Override
	public List<Profile> getProfileByCity(String city) throws Exception {
		// TODO Auto-generated method stub
		
		return profileRepository.getProfileByCity(city);
	
	}

	@Override
	public List<Profile> getProfileByCountry(String country) throws Exception {
		// TODO Auto-generated method stub
		
		return profileRepository.getProfileByCountry(country);
	}

	@Override
	public List<Profile> getProfileByState(String state) throws Exception {
		// TODO Auto-generated method stub
		
		return profileRepository.getProfileByState(state);
	
	}

	@Override
	public Profile getProfileByFullNameAndCity(String fullName, String city) throws Exception {
		// TODO Auto-generated method stub
		//return profileRepository.getProfileByFullNameAndCity( fullName, city);
		return null;
	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub
		profileRepository.deleteById(userId);
	}

	
	
	

}

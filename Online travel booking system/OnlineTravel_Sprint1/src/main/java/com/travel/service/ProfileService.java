package com.travel.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.travel.entity.Profile;



@Service
public interface ProfileService {
	public Profile addProfile(Profile profile);
	public List<Profile> getAllProfiless()throws Exception;

	public Profile getProfileByFullName(String fullName)throws Exception;
	public List<Profile> getProfileByCity(String city)throws Exception;
	public List<Profile>getProfileByCountry(String country)throws Exception;
	public List<Profile>getProfileByState(String state)throws Exception;
	public Profile getProfileByFullNameAndCity(String fullName,String city)throws Exception;
	public void delete(int id);


}

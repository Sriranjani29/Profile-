package com.travel.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.travel.entity.Profile;


@Repository

public interface IProfileCustomRepository {
	public Profile getProfileByFullName(String fullName)throws Exception;
	public List<Profile> getProfileByCity(String city)throws Exception;
	public List<Profile>getProfileByCountry(String country)throws Exception;
	public List<Profile>getProfileByState(String state)throws Exception;
}

package com.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.Profile;
import com.travel.service.ProfileService;


@RestController
@RequestMapping("travel/profile")
public class ProfileController {
	@Autowired
	ProfileService profileService;

	public ProfileController() {
		System.out.println("\n\n\n====>> Inside Constructor " + this);
	}

	@PostMapping("/addprofile")
	public ResponseEntity<String> addProfile(@RequestBody Profile profile) {
		try {
			Profile savedProfile=profileService.addProfile(profile);
			String responseMsg = savedProfile.getFullName()+  "saved with id"  +savedProfile.getUserId();
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/userFullname/{searchFullname}")
	public Profile abc1(@PathVariable String searchFullname)throws Exception
	{
		return profileService.getProfileByFullName(searchFullname);
	}
	
	@GetMapping("/city/{city}")
	public List<Profile> abc2(@PathVariable String city)throws Exception
	{
	
		return profileService.getProfileByCity(city);
	}
	@GetMapping("/country/{country}")
	public List<Profile> abc3(@PathVariable String country)throws Exception
	{
		
		return profileService.getProfileByCountry(country);
	}
	@GetMapping("/state/{state}")
	public List<Profile> abc4(@PathVariable String state)throws Exception
	{
	
		return profileService.getProfileByState(state);
	}
	
	@GetMapping("/userFullnameandcity/{searchFullname}")
	public Profile abc5(@PathVariable String searchFullname,@RequestParam String city)throws Exception
	{
		if(city != null)
		{
			return profileService.getProfileByFullNameAndCity(searchFullname, city);
		}
		else return null;
		
	}



	@GetMapping("/profiles")
	public List<Profile> getAllProfiles() {
		try {
			List<Profile> allExtractedProfiles = profileService.getAllProfiless();

			return allExtractedProfiles;

		} catch (Exception e) {
			System.out.println(e);

		}

		return null;
	
	}
	
	@DeleteMapping("/userid/{searchUserId}")
	public void deleteUser(@PathVariable int searchUserId)
	{
		try {
			profileService.delete(searchUserId);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

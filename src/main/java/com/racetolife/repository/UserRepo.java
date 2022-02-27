package com.racetolife.repository;

import org.springframework.stereotype.Repository;

import com.racetolife.model.UserDetailsDO;

@Repository
public interface UserRepo {

	public String changeEmail(String oldEmail, String newEmail);

	public UserDetailsDO getUserDetails(String email);

	public String changePassword(String emailId, String passwordNew);

	public String getPassword(String email);
	
}
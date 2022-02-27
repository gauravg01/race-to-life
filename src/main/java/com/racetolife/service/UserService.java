package com.racetolife.service;

import org.springframework.stereotype.Service;

import com.racetolife.model.UserDetailsDO;

@Service
public interface UserService {

	public String changeEmail(String oldEmail, String newEmail);

	public UserDetailsDO getUserDetails(String email);

	public String changePassword(String emailId, String passwordNew);

	public String getPassword(String email);

}
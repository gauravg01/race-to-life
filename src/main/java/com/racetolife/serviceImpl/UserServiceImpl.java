package com.racetolife.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racetolife.model.UserDetailsDO;
import com.racetolife.repository.UserRepo;
import com.racetolife.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public String changeEmail(String oldEmail, String newEmail) {
		return userRepo.changeEmail(oldEmail,newEmail);
	}

	@Override
	public UserDetailsDO getUserDetails(String email) {
		return userRepo.getUserDetails(email);
	}

	@Override
	public String changePassword(String emailId, String passwordNew) {
		return userRepo.changePassword(emailId,passwordNew);
	}

	@Override
	public String getPassword(String email) {
		return userRepo.getPassword(email);
	}

}
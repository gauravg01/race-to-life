package com.racetolife.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racetolife.dao.UserDAO;
import com.racetolife.model.UserDetailsDO;
import com.racetolife.repository.UserRepo;

@Repository
public class UserRepoImpl implements UserRepo {

	@Autowired
	UserDAO dao;

	@Override
	public String changeEmail(String oldEmail, String newEmail) {
		return dao.changeEmail(oldEmail,newEmail);
	}

	@Override
	public UserDetailsDO getUserDetails(String email) {
		return dao.getUserDetails(email);
	}

	@Override
	public String changePassword(String emailId, String passwordNew) {
		return dao.changePassword(emailId, passwordNew);
	}

	@Override
	public String getPassword(String email) {
		return dao.getPassword(email);
	}

}
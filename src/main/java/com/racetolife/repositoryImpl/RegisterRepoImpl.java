package com.racetolife.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racetolife.dao.registerDAO;
import com.racetolife.repository.RegisterRepo;

@Repository
public class RegisterRepoImpl implements RegisterRepo {

	@Autowired
	registerDAO dao;

	public String register(String uname, String password) {
		String result = dao.register(uname,password);
		if(result.equalsIgnoreCase("duplicate"))
			result="User already exists, Please login!";
		else if (result.equalsIgnoreCase("error"))
			result="Unexpected error occured!";
		return result;
	}

	@Override
	public String generateToken(String uname) {
		return (dao.generateToken(uname.toLowerCase()));
	}

	@Override
	public String activateAccount(String token, String username) {
		return (dao.activateAccount(token,username.toLowerCase()));
	}

	@Override
	public String checkUser(String username) {
		return (dao.checkUser(username.toLowerCase()));
	}

}
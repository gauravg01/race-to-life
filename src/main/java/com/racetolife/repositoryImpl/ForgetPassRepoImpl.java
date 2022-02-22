package com.racetolife.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.racetolife.dao.ForgetPassDAO;
import com.racetolife.repository.ForgetPassRepo;

@Repository
public class ForgetPassRepoImpl implements ForgetPassRepo{

	@Autowired
	ForgetPassDAO dao;

	@Override
	public String getForgetPass(String email) {
		String result = dao.getForgetPass(email.toLowerCase());
		return result;
	}
}

package com.racetolife.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.racetolife.repository.ForgetPassRepo;
import com.racetolife.service.ForgetPassService;

@Service
public class ForgetPassServiceImpl implements ForgetPassService{

	@Autowired
	ForgetPassRepo repo;

	@Override
	public String getForgetPass(String email) {
		return repo.getForgetPass(email);
	}
}
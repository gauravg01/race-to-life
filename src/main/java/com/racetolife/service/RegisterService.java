package com.racetolife.service;

import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
	
	public String register(String uname, String password);

	public void sendEmail(String name,String uname, String regSucc, String message);

	public String generateToken(String uname);

	public String activateAccount(String token, String username);

	public String checkUser(String username);

}
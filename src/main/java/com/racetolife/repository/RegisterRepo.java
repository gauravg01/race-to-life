package com.racetolife.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo {
	
	public String register(String uname, String password);

	public String generateToken(String uname);

	public String activateAccount(String token, String username);

	public String checkUser(String username);

}
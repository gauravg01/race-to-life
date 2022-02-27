package com.racetolife.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.racetolife.mapper.UserDetailsMapper;
import com.racetolife.model.UserDetailsDO;

@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${queryUserAuthentication}")
	private String queryUserAuthentication;

	@Value("${queryUserAuthenticationRole}")
	private String queryUserAuthenticationRole;
	
	@Value("${queryToGetPassword}")
	private String queryToGetPassword;
	
	@Value("${queryToChangeEmailofUsers}")
	private String queryToChangeEmailofUsers;
	
	@Value("${queryToChangeEmailofAuth}")
	private String queryToChangeEmailofAuth;
	
	@Value("${queryToChangePasswordOfUsers}")
	private String queryToChangePasswordOfUsers;
	
	@Value("${queryToGetUserDetails}")
	private String queryToGetUserDetails;
	
	@Value("${queryToGetUserId}")
	private String queryToGetUserId;
	
	@Value("${queryToGetUserEmail}")
	private String queryToGetUserEmail;
	
	public static Logger logger = LoggerFactory.getLogger(registerDAO.class);
	
	public String getPassword(String email) {
		String sql=queryToGetPassword;
		String password=null;
		try {
			password=jdbcTemplate.queryForObject(sql, new Object[] {email}, String.class);
		}
		catch(Exception e) {
			//System.out.println(password+" "+e);
			logger.error(e.toString());
		}
		return password;
	}
	
	public String changeEmail(String oldEmail, String newEmail) {
		String sql1=queryToChangeEmailofUsers;
		String sql2=queryToChangeEmailofAuth;
		int result=0;
		try {
			result=jdbcTemplate.update(sql1, newEmail, oldEmail);
			result=jdbcTemplate.update(sql2, newEmail, oldEmail);
		}
		catch(Exception e) {
			logger.error(e.toString());
		}
		if(result>0)
			return "success";
		else
			return "error";
	}
	
	public String changePassword(String emailId, String password) {
		String sql=queryToChangePasswordOfUsers;
		int result=0;
		try {
			result=jdbcTemplate.update(sql,password,emailId);
		}
		catch(Exception e) {
			logger.error(e.toString());
		}
		if(result==1)
			return "success";
		else
			return "error";
	}
	
	public UserDetailsDO getUserDetails(String email) {
		String sql=queryToGetUserDetails;
		UserDetailsDO user = new UserDetailsDO();
		try {
			user=jdbcTemplate.queryForObject(sql, new Object[] {email},new UserDetailsMapper());
		}
		catch(Exception e) {
			logger.error(e.toString());
		}
		return user;
	}

	public int getUserId(String email) {
		String sql=queryToGetUserId;
		int result=0;
		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {email}, Integer.class);
		}
		catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	public String getUserEmail(int id) {
		String sql=queryToGetUserEmail;
		String result=null;
		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {id}, String.class);
		}
		catch(Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

}
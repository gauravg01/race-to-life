package com.racetolife.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ForgetPassDAO {
	
	@Value("${queryForgetPass}")
	private String queryForgetPass;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static Logger logger = LoggerFactory.getLogger(ForgetPassDAO.class);
	
	public String getForgetPass(String email) {
		String sql = queryForgetPass;
		String result=null;
		try {
			result = jdbcTemplate.queryForObject(sql,new Object[] {email},String.class);
		}
		catch (EmptyResultDataAccessException e) {
			result = "register";
		}
		catch (Exception e) {
			result = e.toString();
			logger.error(e.toString());
		}
		return result;
	}
}
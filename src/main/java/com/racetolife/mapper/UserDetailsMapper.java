package com.racetolife.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.racetolife.model.UserDetailsDO;

public class UserDetailsMapper implements RowMapper<UserDetailsDO> {

	@Override
	public UserDetailsDO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetailsDO user = new UserDetailsDO();
		user.setEmail(rs.getString("username"));
		return user;
	}
}
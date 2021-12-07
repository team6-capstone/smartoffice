package com.example.demo.info.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.info.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getString("ID"));
		user.setDepartment(rs.getString("Department"));
		user.setRank(rs.getString("Rank"));
		user.setName(rs.getString("Name"));
		user.setPhone(rs.getString("Phone"));
		user.setEmail(rs.getString("Email"));
		user.setPw(rs.getString("PW"));
		user.setStatement(rs.getInt("Statement"));
		return user;
	}
}

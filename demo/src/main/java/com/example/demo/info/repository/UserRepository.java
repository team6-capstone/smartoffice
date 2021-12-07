package com.example.demo.info.repository;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.info.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserRepository {
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final UserRowMapper userRowMapper;
	
	public UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.userRowMapper = new UserRowMapper();
	}
	
	public List<User> findUser() {
		String sql = "SELECT * FROM USER limit 1000";
		
		log.debug("findUser query : {}", UserSql.SELECT);
		
		return namedParameterJdbcTemplate.query(UserSql.SELECT, EmptySqlParameterSource.INSTANCE, this.userRowMapper);
	}
}

package com.example.demo.info.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
		log.debug("findUser query : {}", UserSql.SELECT);
		
		return namedParameterJdbcTemplate.query(UserSql.SELECT, EmptySqlParameterSource.INSTANCE, this.userRowMapper);
	}
	
	public List<User> findByOption(String depCode, int stat) {
		String qry = UserSql.SELECT
					+ UserSql.DEPARTMENT_CONDITION
					+ UserSql.STATEMENT_CONDITION;
		
		SqlParameterSource param = new MapSqlParameterSource("department", depCode).addValue("statement", stat);
		
		return namedParameterJdbcTemplate.query(qry, param, this.userRowMapper);
	}
	
	public User insert(User user) {
		SqlParameterSource parameterSource = new MapSqlParameterSource("id", user.getId())
												.addValue("department", user.getDepartment())
												.addValue("rank", user.getRank())
												.addValue("name", user.getName())
												.addValue("phone", user.getPhone())
												.addValue("email", user.getEmail())
												.addValue("pw", user.getPw())
												.addValue("statement", user.getStatement());
		int affectedRows = namedParameterJdbcTemplate.update(UserSql.INSERT, parameterSource);
		log.debug("{} inserted", affectedRows);
		return user;
	}
	
	public int updateById(User user) {
		String qry = UserSql.UPDATE + UserSql.ID_CONDITION;
		
		SqlParameterSource parameterSource = new MapSqlParameterSource("id", user.getId())
												.addValue("department", user.getDepartment())
												.addValue("rank", user.getRank())
												.addValue("name", user.getName())
												.addValue("phone", user.getPhone())
												.addValue("email", user.getEmail())
												.addValue("pw", user.getPw())
												.addValue("statement", user.getStatement());
		return namedParameterJdbcTemplate.update(qry, parameterSource);
	}
	
	public int deleteById(String id) {
		SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
		return namedParameterJdbcTemplate.update(UserSql.DELETE + UserSql.ID_CONDITION, parameterSource);
	}
}

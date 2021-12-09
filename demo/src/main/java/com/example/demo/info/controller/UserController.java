package com.example.demo.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.info.model.User;
import com.example.demo.info.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// 테스트용 사용x
	@GetMapping("userInfo")
	public User userInfo( ) {
		log.debug("/userInfo start");
		User user = userService.getUserInfo();
		return user;
	}
	
	// 옵션별 user 검색
	@GetMapping("userListByOption/{department}/{statement}")
	public Object userByOption(@PathVariable("department") String depCode, @PathVariable("statement") int stat) {
		log.debug("depCode = {}, statatement = {}", depCode, stat);
		List<User> userList = userService.findUserByOption(depCode, stat);
		return userList;
	}
}

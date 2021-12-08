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
	
	@GetMapping("userInfo")
	public User userInfo( ) {
		log.debug("/userInfo start");
		User user = userService.getUserInfo();
		return user;
	}
	
	@GetMapping("userList")
	public Object userList() {
		log.debug("/userList start");
		List<User> userList = userService.getUserList();
		return userList;
	}
	
	@GetMapping("userListByCode/{department}/{statement}")
	public Object userByCode(@PathVariable("department") String depCode, @PathVariable("statement") int stat) {
		log.debug("depCode = {}, statatement = {}", depCode, stat);
		List<User> userList = userService.findUserByDepANDStat(depCode, stat);
		return userList;
	}
	
	@PostMapping(value="userAdd")
	public ResponseEntity<User> userAdd(@RequestBody User user) {
		try {
			log.debug("user = {}", user.toString());
			return new ResponseEntity<>(userService.insert(user), HttpStatus.OK);
		}
		catch (Exception e) {
			log.error(e.toString());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

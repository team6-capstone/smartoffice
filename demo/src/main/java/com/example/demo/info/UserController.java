package com.example.demo.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.info.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/user")
	public User userInfo( ) {
		log.debug("/user start");
		User user = userService.getUserInfo();
		return user;
	}
	
	@GetMapping("/userList")
	public Object userList() {
		log.debug("/userList start");
		List<User> userList = userService.getUserList();
		return userList;
	}
}

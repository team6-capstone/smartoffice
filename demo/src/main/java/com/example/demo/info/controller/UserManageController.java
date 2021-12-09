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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.info.model.User;
import com.example.demo.info.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("manager")
public class UserManageController {
	private UserService userService;
	
	@Autowired
	public UserManageController(UserService userService) {
		this.userService = userService;
	}
	
	// 전체 user 조회
	@GetMapping("userList")
	public Object userList() {
		log.debug("/userList start");
		List<User> userList = userService.getUserList();
		return userList;
	}
	
	// 옵션별 user 검색
	@GetMapping("userListByOption/{department}/{statement}")
	public Object userByOption(@PathVariable("department") String depCode, @PathVariable("statement") int stat) {
		log.debug("depCode = {}, statatement = {}", depCode, stat);
		List<User> userList = userService.findUserByOption(depCode, stat);
		return userList;
	}
	
	// user 삽입
	@PostMapping(value="userAdd")
	public ResponseEntity<User> userAdd(@RequestBody User user) {
		try {
			log.debug("user = {}", user.toString());
			return new ResponseEntity<>(userService.insert(user), HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.toString());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ResponseBody
	@PostMapping(value="userDelete")
	public ResponseEntity<String> userDelete(@RequestParam(value="id") String id) {
		try {
			log.debug("user id ={}", id);
			int deletedCnt = userService.deleteById(id);
			return new ResponseEntity<>(String.format("%d deleted", deletedCnt), HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.toString());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

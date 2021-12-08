package com.example.demo.info.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.info.model.User;
import com.example.demo.info.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getUserInfo() {
		User user = new User();
		user.setId("id");
		user.setDepartment("dep");
		user.setRank("rank");
		user.setName("name");
		user.setPhone("phone");
		user.setEmail("email");
		user.setPw("pw");
		user.setStatement(0);
		
		return user;
	}
	
	public List<User> getUserList() {
		return this.userRepository.findUser();
	}
	
	public List<User> findUserByDepANDStat(String depCode, int stat) {
		log.debug("depCode = {}, statement = {}", depCode, stat);
		return this.userRepository.findByCountryCodeAndStat(depCode, stat);
	}
	
	public User insert(User user) {
		return this.userRepository.insert(user);
	}
}

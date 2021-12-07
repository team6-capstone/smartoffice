package com.example.demo.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.info.model.User;
import com.example.demo.info.repository.UserRepository;

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
}

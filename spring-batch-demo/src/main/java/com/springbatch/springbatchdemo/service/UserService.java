package com.springbatch.springbatchdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbatch.springbatchdemo.model.User;
import com.springbatch.springbatchdemo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public List<User> getUserByDept(String dept) {

		return userRepository.findByDept(dept);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

}

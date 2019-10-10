package com.mimaraslan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mimaraslan.model.User;
import com.mimaraslan.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getUserAll() {
		return userRepository.findAll();
	}
}

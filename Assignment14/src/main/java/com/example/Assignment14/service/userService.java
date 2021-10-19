package com.example.Assignment14.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Assignment14.domain.User;
import com.example.Assignment14.repo.userRepository;

@Service
public class userService {
	@Autowired
	private userRepository userRepo;
	
	public void save(User user) {
		userRepo.save(user);
	}
	
	public User findById (Long userId) {
		return userRepo.findById(userId);
	}
	public int size () {
		return userRepo.size();
	}
	
}

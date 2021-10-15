package com.example.Assignment14.repo;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.Assignment14.domain.User;

@Repository
public class userRepository {
	private Map<Long, User> users = new HashMap<>();
	
	public void save (User user) {
		users.put(user.getId(), user);
	}
	
	public User findById (Long userId) {
		return users.get(userId);
	}
}

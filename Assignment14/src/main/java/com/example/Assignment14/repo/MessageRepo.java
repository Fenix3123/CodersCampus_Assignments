package com.example.Assignment14.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.Assignment14.domain.Message;
import com.example.Assignment14.domain.User;

@Repository
public class MessageRepo {
public List<Message> msg = new ArrayList<>();
	
	public void save (Message obj) {
		msg.add(obj);
	}
}

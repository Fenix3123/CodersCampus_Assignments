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
	public Map<Integer, List<Message>> msg = new HashMap<>();
	//how to add into the message list
	public void save (Integer i, Message obj) {
		if(msg.containsKey(i)) {
			msg.get(i).add(obj);
		}
		else {
			List<Message> nameOfList = new ArrayList<>();
			msg.put(i, nameOfList);
			msg.get(i).add(obj);
		}
	}
}

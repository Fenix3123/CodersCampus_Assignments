package com.example.Assignment14.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Assignment14.domain.Message;
import com.example.Assignment14.repo.MessageRepo;
import com.example.Assignment14.repo.userRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepo msgRepo;
	
	public void save (Integer i, Message str) {
		msgRepo.save(i, str);
	}
	
	public Map list() {
		return msgRepo.msg;
	}
}

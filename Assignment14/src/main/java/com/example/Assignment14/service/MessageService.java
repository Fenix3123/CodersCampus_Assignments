package com.example.Assignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Assignment14.domain.Message;
import com.example.Assignment14.repo.MessageRepo;
import com.example.Assignment14.repo.userRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepo msgRepo;
	
	public void save (Message str) {
		msgRepo.save(str);
	}
	
	public List list() {
		return msgRepo.msg;
	}
}

package com.example.Assignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Assignment14.domain.Channel;
import com.example.Assignment14.repo.ChannelRepo;

@Service
public class ChannelService {
	@Autowired
	private ChannelRepo chnRepo;
	
	public List<Channel> getChannelList() {
		return chnRepo.getChannelList();
	}
}

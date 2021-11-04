package com.example.Assignment14.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Assignment14.domain.Channel;

@Repository
public class ChannelRepo {
  Channel general = new Channel(1, "general");
  Channel general2 = new Channel(2, "general2");
  public List <Channel> channelList = new ArrayList<>(List.of(general, general2));
  
public List<Channel> getChannelList() {
	return channelList;
}
public void setChannelList(List<Channel> channelList) {
	this.channelList = channelList;
}
  
}

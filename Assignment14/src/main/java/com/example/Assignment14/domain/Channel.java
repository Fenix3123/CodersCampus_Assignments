package com.example.Assignment14.domain;

public class Channel {
	private int channelId;
	private String channelName;
	
	public Channel(int i, String name) {
		channelId = i;
		channelName = name;
	}
	
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
}

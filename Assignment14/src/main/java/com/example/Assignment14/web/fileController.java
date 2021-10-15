package com.example.Assignment14.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Assignment14.domain.Message;
import com.example.Assignment14.domain.User;
import com.example.Assignment14.service.MessageService;
import com.example.Assignment14.service.userService;

@Controller
public class fileController {
	@Autowired
	private userService userServ;
	private MessageService msgServ;
	Long i = (long) 1;
	Long j = (long) 1;
	
	@GetMapping("/welcome")
	public String getChannels(ModelMap model) {
		User user = new User();
		model.put("user", user);
		return "channel";
	}
	
	@GetMapping("/channels")
	public String getChatChannel(ModelMap model, Message msg) {
		//User user = new User();
		//model.put("user", user);
		model.put("msg", msg);
		return "chat";
	}
	
	@PostMapping("/welcome")
	public String sendName(User user) {
		user.setId(i);
		userServ.save(user);
		return "redirect:/channels";
	}
	
	@PostMapping("/channels")
	public String sendMsg(Message msg) {
		User user = userServ.findById(i);
		i++;
		msg.setUser(user);
		msgServ.save(msg);
		
		return "redirect:/channels/1";
	}
	
	@GetMapping("/channels/1")
	public String getChatChannel(ModelMap model) {
		List<Message> ListMessage = msgServ.list();
		//model.put("user", user);
		model.put("msg_l", ListMessage);
		return "chat";
	}
}


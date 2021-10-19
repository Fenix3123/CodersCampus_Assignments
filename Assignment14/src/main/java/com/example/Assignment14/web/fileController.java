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
	
	@PostMapping("/welcome")
	public String sendName(User user) {
		user.setId(i);
		userServ.save(user);
		i++;
		return "redirect:/channels/1/"+j;
	}
	
	@GetMapping("/channels/1/{userid}")
	public String getChatChannel(ModelMap model, Message msg, @PathVariable Long userid) {
		if(j < userServ.size()) {
			j++;
		}
		List<Message> L_msg = msgServ.list();
		model.put("msg", msg);
		model.put("L_msg", L_msg);
		return "chat";
	}
	
	@PostMapping("/channels/1/{userid}")
	public String sendMsg(Message msg, @PathVariable Long userid) {
		//figure out how to assign the user to the message
		User user = userServ.findById(userid);
		
		msg.setUser(user);
		msgServ.save(msg);
		
		return "redirect:/channels/1/"+userid;
	}
	
	
}


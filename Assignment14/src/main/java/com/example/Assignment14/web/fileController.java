package com.example.Assignment14.web;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Assignment14.domain.Message;
import com.example.Assignment14.domain.PostObj;
import com.example.Assignment14.domain.User;
import com.example.Assignment14.service.MessageService;
import com.example.Assignment14.service.userService;

@Controller
public class fileController {
	@Autowired 
	private userService userServ;
	@Autowired 
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
	public String sendName(@RequestBody PostObj postobj) {
		postobj.getUser().setId(i);
		userServ.save(postobj.getUser());
		i++;
		if(j < userServ.size()) {
			j++;
		}
		return "redirect:/channels/"+postobj.getChannelId()+"/"+j;
	}
	
	@GetMapping("/channels/{channelId}/{userid}")
	public String getChatChannel(ModelMap model, Message msg, @PathVariable Long userid, @PathVariable Integer channelId) {
//		List<Message> L_msg = msgServ.list();
//		if(L_msg.size() == 0){
//	
//		}else {
//			 model.put("L_msg", L_msg);
//		}
//			List<Message> L_msg = msgServ.list();
//			model.put("msg", msg);
		return "chat";
	}
	
	@PostMapping("/channels/{channelId}/{userid}")
	public String sendMsg(@RequestBody Message msg, @PathVariable Long userid, @PathVariable Integer channelId) {
		//figure out how to assign the user to the message
		User user = userServ.findById(userid);
		msg.setUser(user);
		msgServ.save(channelId, msg);
		//List<Message> L_msg = msgServ.list();
		return "redirect:/channels/1/"+userid;
	}
	
	@GetMapping("/getList")
	@ResponseBody
	public Map getMessageList() {
		return msgServ.list();
	}
	
	
}


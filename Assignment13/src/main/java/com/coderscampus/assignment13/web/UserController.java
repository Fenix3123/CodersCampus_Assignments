package com.coderscampus.assignment13.web;

import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.Address;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//for creating new users
	@GetMapping("/register")
	public String getCreateUser (ModelMap model) {
		
		model.put("user", new User());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String postCreateUser (User user) {
		System.out.println(user);
		userService.saveUser(user);
		return "redirect:/register";
	}
	
	//displaying all users
	@GetMapping("/users")
	public String getAllUsers (ModelMap model) {
		Set<User> users = userService.findAll();
		
		model.put("users", users);
		if (users.size() == 1) {
			model.put("user", users.iterator().next());
		}
		
		return "users";
	}
	
	//displaying indiv and update users
	@GetMapping("/users/{userId}")
	public String getOneUser (ModelMap model, @PathVariable Long userId) {
		User user = userService.findById(userId);
		model.put("users", Arrays.asList(user));
		model.put("user", user);
		return "users";
	}
	
	@PostMapping("/users/{userId}")
	public String postOneUser (User user , @PathVariable Long userId) {
		user.getAddress().setUserId(userId);
		user.getAddress().setUser(user);
		
		userService.saveUser(user);
		//userService.saveAddress(acc);
		return "redirect:/users/"+user.getUserId();
	}
	
	//for the accounts
	@GetMapping("/users/{userId}/accounts")
	public String getCreateAccounts (ModelMap model, @PathVariable Long userId) {
		User user = userService.findById(userId);
		int num = user.getUserId().intValue();
		Account acc = user.getAccounts().get(num);
		model.put("account", acc);
		model.put("user", user);
		
		return "account";
	}
	
	@PostMapping("/users/{userId}/accounts")
	public String postAccounts (@PathVariable Long userId) {
		User user = userService.findById(userId);
		Account acc = new Account();
		int i = user.getAccounts().size();
		acc.setAccountName("Account #"+ (i+1));
		user.getAccounts().add(acc);
		userService.saveAccount(acc);
		userService.saveUser(user);
		return "redirect:/users/"+user.getUserId()+"/accounts";
	}
	
	@PostMapping("/users/{userId}/delete")
	public String deleteOneUser (@PathVariable Long userId) {
		userService.delete(userId);
		return "redirect:/users";
	}
	
	//get mapping for account updating
	@GetMapping("/users/{userId}/accounts/{accountsId}")
	public String updateAccounts (ModelMap model, @PathVariable Long userId, @PathVariable Long accountsId) {
		User user = userService.findById(userId);
		int num = user.getUserId().intValue();
		Account acc = user.getAccounts().get(num);
		model.put("account", acc);
		model.put("user", user);
				
		return "account";
	}
	
	@PostMapping("/users/{userId}/accounts/{accountsId}")
	public String postUpdateAccounts (Account accountWithName, @PathVariable Long userId, @PathVariable Long accountsId) {
		User user = userService.findById(userId);
		Account acc = userService.findByAccountId(accountsId);
		acc.setAccountName(accountWithName.getAccountName());
		userService.saveAccount(acc);
		userService.saveUser(user);
		return "redirect:/users/"+user.getUserId()+"/accounts"+acc.getAccountId();
	}
}

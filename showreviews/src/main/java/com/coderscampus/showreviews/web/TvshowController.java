package com.coderscampus.showreviews.web;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.showreviews.domain.Tvshows;
import com.coderscampus.showreviews.domain.User;
import com.coderscampus.showreviews.service.TvshowsService;
import com.coderscampus.showreviews.service.UserService;

@Controller
public class TvshowController {
	@Autowired
	private TvshowsService tvService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/{userId}/tvshow/{tvId}/delete")
	public String deleteOneTv (@PathVariable Long tvId, @PathVariable Long userId) {
		User user = userService.findById(userId);
		user.setTvshows(user.getTvshows().stream()
									   .filter(tv ->{
										   String str1 = String.valueOf(tv.getId());
										   String str2 = String.valueOf(tvId);
										   return !str1.equals(str2);
									   })
									   .collect(Collectors.toList()));
		userService.saveUser(user);
		return "redirect:/dashboard2";
	}
	
	@PostMapping("/tvshow")
	public String saveTvshow(@AuthenticationPrincipal User user, Tvshows tvshow, String dateofwatch) {
		LocalDate localDate = LocalDate.parse(dateofwatch);
		tvshow.setDate(localDate);
		user = userService.findById(user.getId());
		tvshow.getUsers().add(user);
		user.getTvshows().add(tvshow);
		tvService.saveTvshows(tvshow);
		return "redirect:/dashboard2";
	}
	
	
	
	@GetMapping("/{userId}/tvshow/{tvId}")
	public String getTvshow(ModelMap model, @PathVariable Long tvId, @AuthenticationPrincipal User user) {
		Tvshows tv = tvService.findById(tvId);
		model.put("user", user);
		model.put("tvItem", tv);
		return "tvshowview";
	}
	
	@PostMapping("/{userId}/tvshow/{tvId}")
	public String getTvshow(Tvshows tvshow, String dateofwatch, @PathVariable Long userId) {
		LocalDate localDate = LocalDate.parse(dateofwatch);
		tvshow.setDate(localDate);
		tvService.saveTvshows(tvshow);
		return "redirect:/"+userId+"/tvshow/"+tvshow.getId();
	}
}

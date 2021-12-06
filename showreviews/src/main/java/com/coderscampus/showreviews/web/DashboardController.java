package com.coderscampus.showreviews.web;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.showreviews.domain.Movies;
import com.coderscampus.showreviews.domain.Tvshows;
import com.coderscampus.showreviews.domain.User;
import com.coderscampus.showreviews.service.MoviesService;
import com.coderscampus.showreviews.service.TvshowsService;
import com.coderscampus.showreviews.service.UserService;


@Controller
public class DashboardController {
	@Autowired
	MoviesService moviesService;
	@Autowired
	TvshowsService tvService;
	@Autowired
	UserService userService;
	
	@GetMapping("/dashboard")
	public String getDashBoard(ModelMap model) {
		model.put("movie", new Movies());
		model.put("tvshow", new Tvshows());
		//movies
		List<Movies> movieList = moviesService.findAll();		
		model.put("movieList", movieList);
		return "Dashboard";
	}
	
	@PostMapping("/movie")
	public String saveMovie(@AuthenticationPrincipal User user, Movies movie, String dateofwatch) {
		LocalDate localDate = LocalDate.parse(dateofwatch);
		movie.setDate(localDate);
		user = userService.findById(user.getId());
		movie.getUsers().add(user);
		user.getMovies().add(movie);
		moviesService.saveMovies(movie);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/tvshow")
	public String saveTvshow(@AuthenticationPrincipal User user, Tvshows tvshow, String dateofwatch) {
		LocalDate localDate = LocalDate.parse(dateofwatch);
		tvshow.setDate(localDate);
		user = userService.findById(user.getId());
		tvshow.getUsers().add(user);
		user.getTvshows().add(tvshow);
		tvService.saveTvshows(tvshow);
		return "redirect:/dashboard";
	}
}

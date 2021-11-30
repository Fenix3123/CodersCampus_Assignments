package com.coderscampus.showreviews.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.showreviews.domain.Movies;
import com.coderscampus.showreviews.domain.Tvshows;
import com.coderscampus.showreviews.domain.User;
import com.coderscampus.showreviews.service.MoviesService;
import com.coderscampus.showreviews.service.TvshowsService;

@Controller
public class DashboardController {
	@Autowired
	MoviesService moviesService;
	@Autowired
	TvshowsService tvService;
	
	@GetMapping("/dashboard")
	public String getDashBoard(ModelMap model) {
		model.put("movie", new Movies());
		return "Dashboard";
	}
	
	@PostMapping("/movie")
	public String saveMovie(Movies movie) {
		System.out.println(movie);
		moviesService.saveMovies(movie);
		return "redirect:/dashboard";
	}
}

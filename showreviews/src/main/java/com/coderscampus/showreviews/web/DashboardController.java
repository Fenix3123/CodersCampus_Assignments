package com.coderscampus.showreviews.web;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String getDashBoard(@AuthenticationPrincipal User user, ModelMap model) {
		model.put("movie", new Movies());
		model.put("tvshow", new Tvshows());
		model.put("user", user);
		//movies
		user = userService.findById(user.getId());
		List<Movies> movieList = user.getMovies();	
		List<Tvshows> tvList = user.getTvshows();
		model.put("movieList", movieList);
		model.put("tvList", tvList);
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
	
	@PostMapping("/{userId}/movie/{movieId}/delete")
	public String deleteOneMovie (@PathVariable Long movieId, @PathVariable Long userId) {
		User user = userService.findById(userId);
		user.setMovies(user.getMovies().stream()
									   .filter(movie ->{
										   String str1 = String.valueOf(movie.getId());
										   String str2 = String.valueOf(movieId);
										   return !str1.equals(str2);
									   })
									   .collect(Collectors.toList()));
		userService.saveUser(user);
		return "redirect:/dashboard";
	}
	
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
	
	@GetMapping("/{userId}/movie/{movieId}")
	public String getMovie(ModelMap model, @PathVariable Long movieId, @AuthenticationPrincipal User user) {
		Movies movie = moviesService.findById(movieId);
		model.put("user", user);
		model.put("movieItem", movie);
		return "/movieview";
	}
	
	@PostMapping("/{userId}/movie/{movieId}")
	public String getMovie(Movies movie, String dateofwatch, @PathVariable Long userId) {
		LocalDate localDate = LocalDate.parse(dateofwatch);
		movie.setDate(localDate);
		moviesService.saveMovies(movie);
		return "redirect:/"+userId+"/movie/"+movie.getId();
	}
	
	@GetMapping("/{userId}/tvshow/{tvId}")
	public String getTvshow(ModelMap model, @PathVariable Long tvId, @AuthenticationPrincipal User user) {
		Tvshows tv = tvService.findById(tvId);
		model.put("user", user);
		model.put("tvItem", tv);
		return "tvshowview";
	}
	
	@PostMapping("/{userId}/tvshow/{tvId}")
	public String getTvshow(Tvshows tvshow, String dateofwatch) {
		LocalDate localDate = LocalDate.parse(dateofwatch);
		tvshow.setDate(localDate);
		tvService.saveTvshows(tvshow);
		return "redirect:/tvshow/"+tvshow.getId();
	}
}

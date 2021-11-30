package com.coderscampus.showreviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.showreviews.domain.Authorities;
import com.coderscampus.showreviews.domain.Movies;
import com.coderscampus.showreviews.repositories.AuthoritiesRepository;
import com.coderscampus.showreviews.repositories.MoviesRepository;

@Service
public class MoviesService {
	@Autowired
	MoviesRepository moviesRepo;
	
	public Movies saveMovies(Movies movie) {
		return moviesRepo.save(movie);
	}
}

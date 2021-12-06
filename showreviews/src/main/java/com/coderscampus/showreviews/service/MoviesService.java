package com.coderscampus.showreviews.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.showreviews.domain.Movies;
import com.coderscampus.showreviews.repositories.MoviesRepository;

@Service
public class MoviesService {
	@Autowired
	MoviesRepository moviesRepo;
	
	public Movies saveMovies(Movies movie) {
		return moviesRepo.save(movie);
	}

	public List<Movies> findAll() {
		// TODO Auto-generated method stub
		return moviesRepo.findAll();
	}
}

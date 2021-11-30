package com.coderscampus.showreviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.showreviews.domain.Tvshows;
import com.coderscampus.showreviews.repositories.TvshowsRepository;

@Service
public class TvshowsService {
	@Autowired
	TvshowsRepository tvRepo;
	
	public Tvshows saveTvshows(Tvshows tv) {
		return tvRepo.save(tv);
	}
}

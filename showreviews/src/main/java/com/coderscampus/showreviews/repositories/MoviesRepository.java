package com.coderscampus.showreviews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.showreviews.domain.Authorities;
import com.coderscampus.showreviews.domain.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long>{

}

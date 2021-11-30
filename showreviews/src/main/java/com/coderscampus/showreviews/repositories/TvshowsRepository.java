package com.coderscampus.showreviews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.showreviews.domain.Tvshows;

@Repository
public interface TvshowsRepository extends JpaRepository<Tvshows, Long>{

}

package com.global.rest.domainAnime;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface Animerepository  extends JpaRepository<Anime, Long>{
	List<Anime> findByRate(Integer rate);
	boolean existsByTitle(String title);
    @Query("SELECT a FROM Anime a WHERE a.title LIKE %:keyword%")
    List<Anime> searchByTitle(@Param("keyword") String keyword);
}

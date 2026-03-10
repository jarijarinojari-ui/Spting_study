package com.global.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.rest.entity.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
	
	@Query("SELECT m FROM Music m " +
		       "WHERE (:title IS NULL OR UPPER(m.title) LIKE UPPER(CONCAT('%', :title, '%'))) " +
		       "AND (:vocal IS NULL OR UPPER(m.vocal) LIKE UPPER(CONCAT('%', :vocal, '%'))) " +
		       "ORDER BY m.musicNo DESC")
	
	Page<Music> getMusicList(
			@Param("title") String title
			, @Param("vocal") String vocal
			, Pageable pageable);

}

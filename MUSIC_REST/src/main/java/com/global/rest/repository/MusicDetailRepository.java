package com.global.rest.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.rest.entity.MusicDetail;

@Repository
public interface MusicDetailRepository extends JpaRepository<MusicDetail, Long> {
	
	@Modifying
	@Query("DELETE FROM MusicDetail md WHERE md.music.musicNo = :musicNo")
	void deleteByMusicNo(@Param("musicNo") Long musicNo);
	// 생성, 조회하는거 해보셈
	
	Page<MusicDetail> getMusicDetailList (
			@Param("releaseComp") String releaseComp
			, @Param("releaseDate") LocalDate releaseDate
			, Pageable pagealbe
		
			);
}

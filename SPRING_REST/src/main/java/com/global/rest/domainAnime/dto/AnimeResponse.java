package com.global.rest.domainAnime.dto;

import java.time.LocalDateTime;

import com.global.rest.domainAnime.Anime;

public record AnimeResponse(Long id, String title, Integer rate, LocalDateTime createdAt) {
	public static AnimeResponse from(Anime anime) {
		return new AnimeResponse(anime.getId(), anime.getTitle(), anime.getRate(), anime.getCreatedAt());
	}
}

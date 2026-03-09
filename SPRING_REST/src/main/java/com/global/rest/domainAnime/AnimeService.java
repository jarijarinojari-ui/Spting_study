package com.global.rest.domainAnime;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.rest.domainAnime.dto.AnimeRequest;
import com.global.rest.domainAnime.dto.AnimeResponse;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnimeService {
	
	private final Animerepository animeRepsitory;

	public List<AnimeResponse> getAnimes() {
		return animeRepsitory.findAll().stream()
				.map(AnimeResponse::from)
				.toList();
	}
	public List<AnimeResponse> getAnimesByRate(Integer rate) {
		return animeRepsitory.findByRate(rate).stream()
				.map(AnimeResponse::from)
				.toList();
	}
	public List<AnimeResponse> getAnimesByTitle(String keyword) {
		return animeRepsitory.searchByTitle(keyword).stream()
				.map(AnimeResponse::from)
				.toList();
	}
	
	public AnimeResponse getAnime(Long id) {
		return animeRepsitory.findById(id)
				.map(AnimeResponse::from)
				.orElseThrow(()->new EntityNotFoundException("애니메이션을 찾을 수 없습니다: "+id));
	}

	@Transactional
	public AnimeResponse createAnime(AnimeRequest request) {
		if (animeRepsitory.existsByTitle(request.title())) {throw new IllegalArgumentException("이미 존재하는 작품입니다");}
		Anime anime=Anime.create(request.title(), request.rate());
		Anime savedAnime = animeRepsitory.save(anime);
		return AnimeResponse.from(savedAnime);
	}
	@Transactional
	public AnimeResponse updateAnime(Long id, AnimeRequest request) {
		Anime anime=animeRepsitory.findById(id)
				.orElseThrow(()->new EntityNotFoundException("애니메이션을 찾을 수 없습니다: "+id));
		anime.update(request.rate());
		return AnimeResponse.from(anime);
	}
	@Transactional
	public void deleteAnime(Long id) {
		if(!animeRepsitory.existsById(id)) {throw new EntityNotFoundException("애니메이션을 찾을 수 없습니다: "+id);}
		animeRepsitory.deleteById(id);
	}
	
}

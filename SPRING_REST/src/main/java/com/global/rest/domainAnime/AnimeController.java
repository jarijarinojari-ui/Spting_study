package com.global.rest.domainAnime;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.rest.domainAnime.dto.AnimeRequest;
import com.global.rest.domainAnime.dto.AnimeResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/animes")
@RequiredArgsConstructor
public class AnimeController {
	
	private final AnimeService animeService;
	
	@GetMapping
	public ResponseEntity<List<AnimeResponse>> searchAnimes(@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "rate", required = false) Integer rate) {
		
		if (keyword != null) {
			return ResponseEntity.ok(animeService.getAnimesByTitle(keyword));
		} else if (rate != null) {
			return ResponseEntity.ok(animeService.getAnimesByRate(rate));
		} else {
			return ResponseEntity.ok(animeService.getAnimes());
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<AnimeResponse> getAnime(@PathVariable("id") Long id){
		return ResponseEntity.ok(animeService.getAnime(id));
	}
	@PostMapping
	public ResponseEntity<AnimeResponse> createAnime(@RequestBody @Valid AnimeRequest request){
		AnimeResponse response=animeService.createAnime(request);
		URI location=URI.create("/api/v1/animes/"+response.id());
		return ResponseEntity.created(location).body(response);
	}
	@PatchMapping("/{id}")
	public ResponseEntity<AnimeResponse> updateAnime(@PathVariable("id") Long id, @RequestBody @Valid AnimeRequest request){
		return ResponseEntity.ok(animeService.updateAnime(id, request));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAnime(@PathVariable("id") Long id){
		animeService.deleteAnime(id);
		return ResponseEntity.noContent().build();
	}
}

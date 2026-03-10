package com.global.rest.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.rest.dto.MusicPageRequestDto;
import com.global.rest.dto.MusicRequestDto;
import com.global.rest.dto.MusicResponseDto;
import com.global.rest.service.MusicService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Music API", description = "음악 기본 정보 CRUD API")
@RestController
@RequestMapping("/api/v1/music")
@RequiredArgsConstructor
public class MusicController {

    private final MusicService musicService;

    @Operation(summary = "음악 조회(페이징)", description = "페이지 번호와 사이즈를 입력하여 목록을 조회합니다.")
    @GetMapping
    public ResponseEntity<List<MusicResponseDto>> getMusicList(
    		@Valid @ParameterObject MusicPageRequestDto requestDto) {
    	
        return ResponseEntity.ok(musicService.getMusicList(requestDto));
    }

    @Operation(summary = "음악 등록", description = "")
    @PostMapping
    public ResponseEntity<MusicResponseDto> createWithDetails(
            @Valid @RequestBody MusicRequestDto dto) {
    	
    	return ResponseEntity.status(HttpStatus.CREATED)
                .body(musicService.createWithDetails(dto));
    }

    @Operation(summary = "음악 삭제", description = "음악 삭제 (연관 DETAIL cascade 삭제)")
    @DeleteMapping("/{musicNo}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "음악 번호") @PathVariable(name = "musicNo") Long musicNo) {
    	
        musicService.delete(musicNo);
        return ResponseEntity.noContent().build();
    }
}

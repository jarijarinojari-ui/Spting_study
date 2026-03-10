package com.global.rest.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.rest.dto.MusicDetailPageRequestDto;
import com.global.rest.dto.MusicDetailResponseDto;
import com.global.rest.dto.MusicPageRequestDto;
import com.global.rest.dto.MusicResponseDto;
import com.global.rest.service.MusicDetailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Music Detail API", description = "음악 상세 정보 CRUD API")
@RestController
@RequestMapping("/api/v1/music-detail")
@RequiredArgsConstructor
public class MusicDetailController {
	// 발매사랑 발매일 두개 입력해서 디테일만 입력하는 스웨거 만들기 디테일 컨트롤러, 디테일 서비스
	// 디테일 삭제를 하던지 뭘하든지
	
	private final MusicDetailService musicDetailService;
	
	@Operation(summary = "음악 상세 정보 조회", description = "페이지 번호와 사이즈를 입력하여 목록을 조회합니다." )
	@GetMapping
	  public ResponseEntity<List<MusicDetailResponseDto>> getMusicDetailList(
	    @Valid @ParameterObject MusicDetailPageRequestDto requestDto) {
	    	
	      return ResponseEntity.ok(MusicDetailService.getMusicDetailList(requestDto));
	 }
}

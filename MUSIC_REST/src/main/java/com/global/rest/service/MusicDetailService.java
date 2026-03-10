package com.global.rest.service;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.rest.dto.MusicDetailPageRequestDto;
import com.global.rest.dto.MusicDetailResponseDto;
import com.global.rest.entity.MusicDetail;
import com.global.rest.repository.MusicDetailRepository;
import com.global.rest.repository.MusicRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MusicDetailService  {
	
	 private final MusicRepository musicRepository;
	 private final MusicDetailRepository musicDetailRepository;

	
	public List<MusicDetailResponseDto> getMusicDetailList (MusicDetailPageRequestDto requestDto) {
		
		Pageable pageable = requestDto.toPageable();
		
		Page<MusicDetail> musicDetailPage = musicDetailRepository.getMusicDetailList(
				requestDto.getReleaseComp()
				, requestDto.getReleaseDate()
				, pageable
				);
		
		return musicDetailPage.getContent().stream()
		        .map(musicDetail -> {
		            // 1. 부모(Music) 테이블 정보 안전하게 추출
		            Long musicNo = (musicDetail.getMusic() != null) ? musicDetail.getMusic().getMusicNo() : null;
		            String title = (musicDetail.getMusic() != null) ? musicDetail.getMusic().getTitle() : "정보 없음";
		            String vocal = (musicDetail.getMusic() != null) ? musicDetail.getMusic().getVocal() : "가수 미상";
		            
		            // 2. MusicDetailResponseDto 생성 (본인 정보는 직접 get)
		            return MusicDetailResponseDto.builder()
		                    .musicNo(musicNo)                           // Music에서 뽑은 번호
		                    .title(title)                               // Music에서 뽑은 제목
		                    .vocal(vocal)                               // Music에서 뽑은 가수
		                    .musicDetailNo(musicDetail.getMusicDetailNo()) // Detail 본인 번호
		                    .releaseComp(musicDetail.getReleaseComp())     // Detail 본인 발매사
		                    .releaseDate(musicDetail.getReleaseDate())     // Detail 본인 발매일
		                    // .createDate(musicDetail.getCreateDate())    // ⚠️ 등록일도 엔티티에 있다면 주석 풀고 넣으세요!
		                    .build();
		        })
		        .collect(Collectors.toList()); // 3. Stream 결과를 List로 묶어서 반환
		
		
	}
}

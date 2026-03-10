package com.global.rest.service;

import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.rest.dto.MusicPageRequestDto;
import com.global.rest.dto.MusicRequestDto;
import com.global.rest.dto.MusicResponseDto;
import com.global.rest.entity.Music;
import com.global.rest.entity.MusicDetail;
import com.global.rest.exception.ResourceNotFoundException;
import com.global.rest.repository.MusicDetailRepository;
import com.global.rest.repository.MusicRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MusicService {

    private final MusicRepository musicRepository;
    private final MusicDetailRepository musicDetailRepository;

    public List<MusicResponseDto> getMusicList(MusicPageRequestDto requestDto) {
    	
    	Pageable pageable = requestDto.toPageable();
    	
    	Page<Music> musicPage = musicRepository.getMusicList(
    			requestDto.getTitle()
    			, requestDto.getVocal()
    			, pageable);

    	return musicPage.getContent().stream()
                .map(music -> {
                    Long musicDetailNo = (music.getMusicDetail() != null) 
                                         ? music.getMusicDetail().getMusicDetailNo() : null;
                    String releaseComp = (music.getMusicDetail() != null) 
                    		? music.getMusicDetail().getReleaseComp() : "정보 없음";
                    LocalDate releaseDate = (music.getMusicDetail() != null) 
                                         ? music.getMusicDetail().getReleaseDate() : null;

                    return new MusicResponseDto(
                        music.getMusicNo()
                        , music.getTitle()
                        , music.getVocal()
                        , musicDetailNo
                        , releaseComp
                        , releaseDate
                        , music.getCreateDate()
                    );
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public MusicResponseDto createWithDetails(MusicRequestDto dto) {
    	
    	Music music = Music.builder()
                .title(dto.getTitle())
                .vocal(dto.getVocal())
                .build();
        
        Music savedMusic = musicRepository.save(music);
        
        MusicDetail detail = MusicDetail.builder()
                .music(savedMusic)
                .releaseComp(dto.getReleaseComp())
                .releaseDate(dto.getReleaseDate())
                .build();
        
        MusicDetail savedMusicDetail = musicDetailRepository.save(detail);
        
        return new MusicResponseDto(
                savedMusic.getMusicNo()
                , savedMusic.getTitle()
                , savedMusic.getVocal()
                , savedMusicDetail.getMusicDetailNo()
                , savedMusicDetail.getReleaseComp()
                , savedMusicDetail.getReleaseDate()
                , savedMusic.getCreateDate()
            );
    }

    @Transactional
    public void delete(Long musicNo) {
    	
        Music music = musicRepository.findById(musicNo)
                .orElseThrow(() -> new ResourceNotFoundException("음악", musicNo));
        
        musicRepository.delete(music);
        
        musicDetailRepository.deleteByMusicNo(musicNo);
    }
}

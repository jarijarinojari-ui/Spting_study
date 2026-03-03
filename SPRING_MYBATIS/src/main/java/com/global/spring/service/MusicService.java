package com.global.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.spring.domain.Music;
import com.global.spring.mapper.MusicMapper;

@Service
public class MusicService {

	@Autowired
	private MusicMapper musicMapper;
	
	// 트렌젝션 커밋롤백하는것 이거하면 코드가 프락시가됨
	@Transactional
	public List<Music> selectMusic() {
		return musicMapper.selectMusic();
	}
	@Transactional
	public List<Music> selectMusicList() {
		return musicMapper.selectMusicList();
	}
	@Transactional
	public List<Music> selectMusicOne(Music music) {
		return musicMapper.selectMusicOne(music);
	}
}

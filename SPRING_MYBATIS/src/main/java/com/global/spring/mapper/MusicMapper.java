package com.global.spring.mapper;

import java.util.List;

import com.global.spring.domain.Music;

public interface MusicMapper {
	// 인터페이스와 musicmapper id를 연결하면 인터페이스의 메소드를 호출해서 쿼리문을 실행할 수 있다.
	public List<Music> selectMusicList();
	public List<Music> selectMusic();
	public List<Music> selectMusicOne(Music music);
}

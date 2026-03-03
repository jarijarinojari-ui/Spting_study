package com.global.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.spring.domain.Music;
import com.global.spring.service.MusicService;

// 리스파스바디와 컨트롤러바디 어노테이션이 합쳐진것이다.
@RestController
@RequestMapping(value = "/api/music/")
public class MusicRestController {
	
	@Autowired
	private MusicService musicService;
	
	@GetMapping("/music")
	public List<Music> selectMusic(){
		return musicService.selectMusic();
	}
	@GetMapping("/list")
	public List<Music> selectMusicList(){
		return musicService.selectMusicList();
	}
	@GetMapping("/musicOne")
	public List<Music> selectMusicOne( @RequestBody Music music){
		return musicService.selectMusicOne(music);
	}
	
	
}

package com.global.mybatis.dto;

import java.util.Date;

public class Music {
	private Integer music_no;
	private String title;
	private String vocal;
	private Date create_date;
	public Integer getMusic_no() {
		return music_no;
	}
	public void setMusic_no(Integer music_no) {
		this.music_no = music_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVocal() {
		return vocal;
	}
	public void setVocal(String vocal) {
		this.vocal = vocal;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
}

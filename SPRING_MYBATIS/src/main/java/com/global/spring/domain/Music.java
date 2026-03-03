package com.global.spring.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Music {
	Integer musicNo;
	String title;
	String vocal;
	String releaseComp;
	Date releaseDate;
	Date createDate;
}

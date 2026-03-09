package com.global.rest.domainAnime.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AnimeRequest(
		@NotBlank(message = "제목은 필수 입니다")
		String title,
		@Min(1)
		@Max(10)
		Integer rate){}

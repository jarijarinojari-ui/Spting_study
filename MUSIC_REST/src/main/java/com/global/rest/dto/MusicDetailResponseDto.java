package com.global.rest.dto;

import java.time.LocalDate;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "음악 응답 DTO")
public class MusicDetailResponseDto {
	@Schema(description = "음악 번호", example = "1")
    private Long musicNo;

    @Schema(description = "음악 제목", example = "Dynamite")
    private String title;

    @Schema(description = "가수명", example = "BTS")
    private String vocal;
    
    @Schema(description = "음악 상세 번호", example = "1")
    private Long musicDetailNo;

    @Schema(description = "발매사", example = "HYBE")
    private String releaseComp;

    @JsonFormat(pattern = "yyyy.MM.dd")
    @Schema(type = "string", description = "발매일", example = "2026.03.01")
    private LocalDate releaseDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Schema(type = "string", description = "등록일", example = "2026.03.01 12:50")
    private LocalDateTime createDate;
}

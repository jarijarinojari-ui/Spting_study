package com.global.rest.dto;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
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
@Schema(description = "음악 페이지 요청 DTO")
public class MusicPageRequestDto extends BasePageRequest {

    @Size(max = 200)
    @Schema(description = "음악 제목")
    private String title;

    @Size(max = 200)
    @Schema(description = "가수명")
    private String vocal;

    @Size(max = 200, message = "발매사는 200자 이하여야 합니다.")
    @Schema(description = "발매사")
    @Parameter(hidden = true)
    private String releaseComp;

    @JsonFormat(pattern = "yyyy.MM.dd")
    @Parameter(hidden = true)
    @Schema(type = "string", description = "발매일")
    private LocalDate releaseDate;
}

package com.global.rest.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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
@Schema(description = "음악 요청 DTO")
public class MusicRequestDto {

    @NotBlank(message = "제목은 필수입니다.")
    @Size(max = 200, message = "제목은 200자 이하여야 합니다.")
    @Schema(description = "음악 제목", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @NotBlank(message = "가수명은 필수입니다.")
    @Size(max = 200, message = "가수명은 200자 이하여야 합니다.")
    @Schema(description = "가수명", requiredMode = Schema.RequiredMode.REQUIRED)
    private String vocal;

    @NotBlank(message = "발매사는 필수입니다.")
    @Size(max = 200, message = "발매사는 200자 이하여야 합니다.")
    @Schema(description = "발매사", requiredMode = Schema.RequiredMode.REQUIRED)
    private String releaseComp;

    @JsonFormat(pattern = "yyyy.MM.dd")
    @Schema(type = "string", description = "발매일", example = "2026.04.01", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate releaseDate;
}

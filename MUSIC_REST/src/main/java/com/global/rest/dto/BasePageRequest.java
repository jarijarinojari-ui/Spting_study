package com.global.rest.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePageRequest {
	
	@Schema(description = "페이지 번호 (1부터 시작)", defaultValue = "1", example = "1")
    private int page = 1;

	@Schema(description = "한 페이지당 데이터 개수", defaultValue = "10", example = "10")
    private int size = 10;

    public Pageable toPageable() {
        return PageRequest.of(page <= 0 ? 0 : page - 1, size, Sort.by("id").descending());
    }
}

package com.global.rest.domain.user.dto;

import java.time.LocalDateTime;

import com.global.rest.domain.user.User;

public record UserResponse(
	Long id,
	String name,
	String email,
	LocalDateTime createdAt
) {
	public static UserResponse from(User user) {
	   return new UserResponse(
	       user.getId(),
	       user.getName(),
	       user.getEmail(),
	       user.getCreatedAt()
	   );
	}
}

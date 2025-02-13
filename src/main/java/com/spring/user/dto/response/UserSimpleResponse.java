package com.spring.user.dto.response;

public record UserSimpleResponse(
	Long userId,
	String email,
	String name,
	String role
) {
}

package com.spring.user.dto.request;

public record UpdateUserRequest(
	Long userId,
	String email,
	String name,
	String role
) {
}

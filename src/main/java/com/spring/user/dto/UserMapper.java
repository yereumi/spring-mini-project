package com.spring.user.dto;

import com.spring.user.dto.request.UserSimpleRequest;
import com.spring.user.dto.response.UserSimpleResponse;
import com.spring.user.domain.User;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

	public static UserSimpleRequest toUserSimpleRequest(Long userId) {
		return new UserSimpleRequest(userId);
	}

	public static UserSimpleResponse toUserSimpleResponse(User user) {
		return new UserSimpleResponse(
			user.getId(),
			user.getEmail(),
			user.getName(),
			user.getRole().getRole();
		)
	}
}

package com.spring.user.dto;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.user.domain.Role;
import com.spring.user.dto.request.RegisterUserRequest;
import com.spring.user.dto.request.UserSimpleRequest;
import com.spring.user.dto.response.RegisterUserResponse;
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
			user.getRole().getRole()
		);
	}

	public static User toUser(RegisterUserRequest request, PasswordEncoder passwordEncoder) {
		return User.of(
			request.email(),
			passwordEncoder.encode(request.password()),
			request.name(),
			Role.MEMBER
		);
	}

	public static RegisterUserResponse toRegisterUserResponse(User savedUser) {
		return new RegisterUserResponse(
			savedUser.getId(),
			savedUser.getEmail(),
			savedUser.getName(),
			savedUser.getRole().getRole()
		);
	}
}

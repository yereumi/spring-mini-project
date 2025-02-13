package com.spring.user.dto;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.user.domain.Role;
import com.spring.user.dto.request.RegisterUserRequest;
import com.spring.user.dto.request.SimpleUserRequest;
import com.spring.user.dto.response.DeleteUserResponse;
import com.spring.user.dto.response.RegisterUserResponse;
import com.spring.user.dto.response.SimpleUserResponse;
import com.spring.user.domain.User;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

	public static SimpleUserRequest toUserSimpleRequest(Long userId) {
		return new SimpleUserRequest(userId);
	}

	public static SimpleUserResponse toUserSimpleResponse(User user) {
		return new SimpleUserResponse(
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

	public static DeleteUserResponse toDeleteUserResponse() {
		return new DeleteUserResponse(true);
	}
}

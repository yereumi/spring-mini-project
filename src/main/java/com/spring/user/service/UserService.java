package com.spring.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.common.exception.runtime.BaseException;
import com.spring.user.dto.request.RegisterUserRequest;
import com.spring.user.dto.request.UpdateUserRequest;
import com.spring.user.dto.request.UserSimpleRequest;
import com.spring.user.dto.response.RegisterUserResponse;
import com.spring.user.dto.response.UserSimpleResponse;
import com.spring.user.domain.User;
import com.spring.user.dto.UserMapper;
import com.spring.user.exception.UserErrorCode;
import com.spring.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Transactional(readOnly = true)
	public UserSimpleResponse getUser(UserSimpleRequest userSimpleRequest) {
		User user = findUser(userSimpleRequest.userId());

		return UserMapper.toUserSimpleResponse(user);
	}

	@Transactional
	public RegisterUserResponse joinUser(RegisterUserRequest request) {
		User savedUser = userRepository.save(UserMapper.toUser(request, passwordEncoder));

		return UserMapper.toRegisterUserResponse(savedUser);
	}

	@Transactional
	public UserSimpleResponse updateUser(UpdateUserRequest request) {
		validateEmail(request.email());

		User findUser = findUser(request.userId());

		findUser.updateInfo(request.email(), request.name(), request.role());

		return UserMapper.toUserSimpleResponse(findUser);
	}

	private User findUser(Long userId) {
		return userRepository.findById(userId).orElseThrow(
			() -> new BaseException(UserErrorCode.NOT_FOUND_USER)
		);
	}

	private void validateEmail(String changingEmail) {
		if(userRepository.existsByEmail(changingEmail)) {
			throw new BaseException(UserErrorCode.DUPLICATED_EMAIL);
		}
	}
}

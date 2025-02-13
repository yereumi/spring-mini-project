package com.spring.user.service;

import org.springframework.stereotype.Service;

import com.spring.common.exception.runtime.BaseException;
import com.spring.user.dto.request.UserSimpleRequest;
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

	public UserSimpleResponse getUser(UserSimpleRequest userSimpleRequest) {
		User user = userRepository.findById(userSimpleRequest.userId()).orElseThrow(
			() -> new BaseException(UserErrorCode.NOT_FOUND_USER)
		);

		return UserMapper.toUserSimpleResponse(user);
	}
}

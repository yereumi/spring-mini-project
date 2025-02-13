package com.spring.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.user.dto.response.UserSimpleResponse;
import com.spring.user.dto.UserMapper;
import com.spring.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController("/api/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/{userId}")
	public ResponseEntity<UserSimpleResponse> getUser(@PathVariable("userId") Long userId) {
		UserSimpleResponse response = userService.getUser(UserMapper.toUserSimpleRequest(userId));
		return ResponseEntity.ok(response);
	}
}

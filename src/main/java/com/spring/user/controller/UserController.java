package com.spring.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.user.dto.request.DeleteUserRequest;
import com.spring.user.dto.request.RegisterUserRequest;
import com.spring.user.dto.request.UpdateUserRequest;
import com.spring.user.dto.response.DeleteUserResponse;
import com.spring.user.dto.response.RegisterUserResponse;
import com.spring.user.dto.response.SimpleUserResponse;
import com.spring.user.dto.UserMapper;
import com.spring.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController("/api/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/{userId}")
	public ResponseEntity<SimpleUserResponse> getUser(@PathVariable("userId") Long userId) {
		SimpleUserResponse response = userService.getUser(UserMapper.toUserSimpleRequest(userId));

		return ResponseEntity.ok(response);
	}

	@PostMapping()
	public ResponseEntity<RegisterUserResponse> joinUser(@RequestBody RegisterUserRequest request) {
		RegisterUserResponse response = userService.joinUser(request);

		return ResponseEntity.ok(response);
	}

	@PatchMapping("/{userId}")
	public ResponseEntity<SimpleUserResponse> updateUser(@RequestBody UpdateUserRequest request) {
		SimpleUserResponse response = userService.updateUser(request);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<DeleteUserResponse> updateUser(@RequestBody DeleteUserRequest request) {
		DeleteUserResponse response = userService.deleteUser(request);

		return ResponseEntity.ok(response);
	}}

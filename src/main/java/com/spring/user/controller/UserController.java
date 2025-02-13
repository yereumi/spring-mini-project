package com.spring.user.controller;

import org.springframework.web.bind.annotation.RestController;

import com.spring.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController("/api/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
}

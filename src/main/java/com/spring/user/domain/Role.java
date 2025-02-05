package com.spring.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

	ADMIN("어드민"),
	MEMBER("일반회원");

	private final String role;
}

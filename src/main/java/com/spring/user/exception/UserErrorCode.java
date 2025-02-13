package com.spring.user.exception;

import com.spring.common.exception.runtime.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {

	NOT_FOUND_USER("해당 회원을 찾을 수 없습니다.", "USER_001");

	private final String message;
	private final String code;
}

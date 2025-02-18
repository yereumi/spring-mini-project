package com.spring.common.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.common.exception.runtime.BaseException;
import com.spring.common.exception.runtime.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BaseException.class)
	public ExceptionResponse customException(BaseException baseException) {
		return new ExceptionResponse(baseException.getCode(), baseException.getMessage());
	}
}

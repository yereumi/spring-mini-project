package com.spring.post.controller;

import org.springframework.web.bind.annotation.RestController;

import com.spring.post.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;
}

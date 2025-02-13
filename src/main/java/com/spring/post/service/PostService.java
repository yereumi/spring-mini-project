package com.spring.post.service;

import org.springframework.stereotype.Service;

import com.spring.post.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
}

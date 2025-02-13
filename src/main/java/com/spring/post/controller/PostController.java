package com.spring.post.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.post.dto.PostMapper;
import com.spring.post.dto.response.PostSimpleResponse;
import com.spring.post.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController("/api/post")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@GetMapping("/{postId}")
	public ResponseEntity<PostSimpleResponse> getPost(@PathVariable("postId") Long postId) {
		PostSimpleResponse response = postService.getPost(PostMapper.toPostSingleDto(postId));
		return ResponseEntity.ok(response);
	}
}

package com.spring.post.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.post.dto.PostMapper;
import com.spring.post.dto.request.RegisterPostRequest;
import com.spring.post.dto.response.SimplePostResponse;
import com.spring.post.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController("/api/post")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@GetMapping("/{postId}")
	public ResponseEntity<SimplePostResponse> getPost(@PathVariable("postId") Long postId) {
		SimplePostResponse response = postService.getPost(PostMapper.toPostSingleDto(postId));
		return ResponseEntity.ok(response);
	}

	@PostMapping()
	public ResponseEntity<SimplePostResponse> registerPost(@RequestBody RegisterPostRequest request) {
		SimplePostResponse response = postService.registerPost(request);
		return ResponseEntity.ok(response);
	}
}

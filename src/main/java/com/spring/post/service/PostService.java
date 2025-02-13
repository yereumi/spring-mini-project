package com.spring.post.service;

import org.springframework.stereotype.Service;

import com.spring.common.exception.runtime.BaseException;
import com.spring.post.domain.Post;
import com.spring.post.dto.PostMapper;
import com.spring.post.dto.request.PostSingleDto;
import com.spring.post.dto.response.PostSimpleResponse;
import com.spring.post.exception.PostErrorCode;
import com.spring.post.repository.PostRepository;
import com.spring.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	public PostSimpleResponse getPost(PostSingleDto postSingleDto) {
		Post post = postRepository.findById(postSingleDto.postId()).orElseThrow(
			() -> new BaseException(PostErrorCode.NOT_FOUND_POST));

		return PostMapper.toPostSimpleResponse(post, post.getUser().getName());
	}
}

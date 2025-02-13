package com.spring.post.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.common.exception.runtime.BaseException;
import com.spring.post.domain.Post;
import com.spring.post.dto.PostMapper;
import com.spring.post.dto.request.SimplePostDto;
import com.spring.post.dto.request.RegisterPostRequest;
import com.spring.post.dto.response.SimplePostResponse;
import com.spring.post.exception.PostErrorCode;
import com.spring.post.repository.PostRepository;
import com.spring.user.domain.User;
import com.spring.user.exception.UserErrorCode;
import com.spring.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
	private final UserRepository userRepository;

	@Transactional(readOnly = true)
	public SimplePostResponse getPost(SimplePostDto postSingleDto) {
		Post post = postRepository.findById(postSingleDto.postId()).orElseThrow(
			() -> new BaseException(PostErrorCode.NOT_FOUND_POST));

		return PostMapper.toPostSimpleResponse(post, post.getUser().getName());
	}

	@Transactional
	public SimplePostResponse registerPost(RegisterPostRequest request) {
		User findUser = getUser(request.userId());
		Post savedPost = postRepository.save(PostMapper.toPost(request.title(), request.content(), findUser));

		return PostMapper.toPostSimpleResponse(savedPost, findUser.getName());
	}

	private User getUser(Long userId) {
		return userRepository.findById(userId).orElseThrow(
			() -> new BaseException(UserErrorCode.NOT_FOUND_USER)
		);
	}
}

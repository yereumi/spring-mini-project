package com.spring.post.dto;

import com.spring.post.domain.Post;
import com.spring.post.dto.request.SimplePostRequest;
import com.spring.post.dto.response.SimplePostResponse;
import com.spring.user.domain.User;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostMapper {

	public static SimplePostRequest toSimplePostRequest(Long postId) {
		return new SimplePostRequest(postId);
	}

	public static SimplePostResponse toSimplePostResponse(Post post, String author) {
		return new SimplePostResponse(
			post.getId(),
			post.getTitle(),
			post.getContent(),
			author
		);
	}

	public static Post toPost(String title, String content, User findUser) {
		return Post.of(title, content, findUser);
	}
}

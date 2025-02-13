package com.spring.post.dto;

import com.spring.post.domain.Post;
import com.spring.post.dto.request.PostSingleDto;
import com.spring.post.dto.response.PostSimpleResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostMapper {

	public static PostSingleDto toPostSingleDto(Long postId) {
		return new PostSingleDto(postId);
	}

	public static PostSimpleResponse toPostSimpleResponse(Post post, String author) {
		return new PostSimpleResponse(
			post.getId(),
			post.getTitle(),
			post.getContent(),
			author
		);
	}
}

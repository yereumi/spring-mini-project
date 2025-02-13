package com.spring.post.dto.response;

public record PostSimpleResponse(

	Long postId,
	String title,
	String content,
	String author
) {
}

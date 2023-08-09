package com.lalitblog.services;

import java.util.List;

import com.lalitblog.entities.Post;
import com.lalitblog.payload.PostDto;

public interface PostSevice {

	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

	PostDto updatePost(PostDto postDto, Integer postId);

	void deletPost(Integer postId);

	PostDto getPostById(Integer postId);

	List<PostDto> getAllPosts();

	List<PostDto> getPostsByCategory(Integer categoryId);

	List<PostDto> getPostsByUser(Integer userId);

	List<Post> searchPosts(String searchKey);

	
}

package com.lalitblog.services;

import java.util.List;

import com.lalitblog.entities.Post;
import com.lalitblog.payload.PostDto;

public interface PostSevice {

	Post createPost(PostDto postDto,Integer userId,Integer categoryId);

	Post updatePost(PostDto postDto, Integer postId);

	void deletPost(Integer postId);

	Post getPostById(Integer postId);

	List<Post> getAllPosts();

	List<Post> getPostsByCategory(Integer categoryId);

	List<Post> getPostsByUser(Integer userId);

	List<Post> searchPosts(String searchKey);

	
}

package com.lalitblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lalitblog.entities.Category;
import com.lalitblog.entities.Post;
import com.lalitblog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);
}

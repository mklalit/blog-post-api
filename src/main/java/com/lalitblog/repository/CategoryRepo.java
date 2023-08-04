package com.lalitblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lalitblog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}

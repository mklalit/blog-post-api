package com.lalitblog.services;

import java.util.List;

import com.lalitblog.payload.CategoryDto;

public interface CategoryServie {

	// create category
	CategoryDto createCategory(CategoryDto categoryDto);

	// update category
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	// delete
	void deleteCategory(Integer categoryId);

	// get single category
	CategoryDto getSingleCategory(Integer categoryId);

	// get all category
	List<CategoryDto> getAllCategories();
}

package com.lalitblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lalitblog.payload.ApiResponse;
import com.lalitblog.payload.CategoryDto;
import com.lalitblog.services.CategoryServie;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

	@Autowired
	private CategoryServie categoryServie;

	// create category
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createdCategory = this.categoryServie.createCategory(categoryDto);

		return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
	}

	// update category
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable("categoryId") Integer categoryId) {
		CategoryDto updatedCategory = this.categoryServie.updateCategory(categoryDto, categoryId);
		return ResponseEntity.ok(updatedCategory);
	}

	// delete category
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
		this.categoryServie.deleteCategory(categoryId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("category deleted ", true), HttpStatus.OK);
	}

	// get single category
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable("categoryId") Integer categoryId) {
		CategoryDto singleCategory = this.categoryServie.getSingleCategory(categoryId);
		return ResponseEntity.ok(singleCategory);
	}

	// get all category
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {

		List<CategoryDto> allCategories = this.categoryServie.getAllCategories();
		return ResponseEntity.ok(allCategories);

	}

}

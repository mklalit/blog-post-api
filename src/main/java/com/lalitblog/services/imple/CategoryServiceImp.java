package com.lalitblog.services.imple;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalitblog.eceptions.ResourceNotFoundException;
import com.lalitblog.entities.Category;
import com.lalitblog.payload.CategoryDto;
import com.lalitblog.repository.CategoryRepo;
import com.lalitblog.services.CategoryServie;

@Service
public class CategoryServiceImp implements CategoryServie {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category category = this.modelMapper.map(categoryDto, Category.class);

		Category saveCategory = this.categoryRepo.save(category);

		return this.modelMapper.map(saveCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCateforyDescription(categoryDto.getCateforyDescription());
		Category saveCategory = this.categoryRepo.save(category);

		return this.modelMapper.map(saveCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
		this.categoryRepo.delete(category);
	}

	@Override
	public CategoryDto getSingleCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> allCategories = this.categoryRepo.findAll();

		List<CategoryDto> allCategoryDtos = allCategories.stream()
				.map(cat -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return allCategoryDtos;
	}

}

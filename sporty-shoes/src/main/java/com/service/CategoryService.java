package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.model.Category;
import com.repository.CategoryRepository;

@Service
public class CategoryService {
		
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories(){
		
		return categoryRepository.findAll();
		
	}
	
//	@ModelAttribute("categories")
//    public List<Category> initializeCategories() {
//        return categoryRepository.findAll();
//    }
	
	public void addCategory(Category category) {
		
		categoryRepository.save(category);
	}
	
	public void removeCategoryById(int id) {
		categoryRepository.deleteById(id);
	}
	
	
	public Optional<Category> getCatById(int id) {
		
		return categoryRepository.findById(id);
		
	}
	
}

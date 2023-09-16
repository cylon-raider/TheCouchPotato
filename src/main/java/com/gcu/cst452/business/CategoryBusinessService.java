package com.gcu.cst326clc.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.cst326clc.data.CategoryDataService;
import com.gcu.cst326clc.model.CategoryModel;

@Service
public class CategoryBusinessService
{
	@Autowired
	private CategoryDataService categoryDataService;
	
	public List<CategoryModel> getAllCategories() {
		return categoryDataService.getAll();
	}
	
	public void addCategory(CategoryModel category) {
		categoryDataService.create(category);
	}
	
	public void deleteCategory(CategoryModel category) {
		categoryDataService.delete(category);
	}
}

package com.gcu.cst452.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.cst452.data.CategoryDataService;
import com.gcu.cst452.model.CategoryModel;

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

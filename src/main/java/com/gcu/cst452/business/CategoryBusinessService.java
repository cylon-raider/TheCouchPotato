/**
 * Service class for handling category-related business logic.
 * Provides methods for retrieving all categories, adding a category, and deleting a category.
 * It uses CategoryDataService to perform these operations.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.cst452.data.CategoryDataService;
import com.gcu.cst452.model.CategoryModel;

@Service  // Indicates that this class is a service class
public class CategoryBusinessService {

	@Autowired  // Automatically wire the CategoryDataService
	private CategoryDataService categoryDataService;

	/**
	 * Retrieve all categories.
	 *
	 * @return A list of all categories.
	 */
	public List<CategoryModel> getAllCategories() {
		// Call the getAll method of categoryDataService to retrieve all categories
		return categoryDataService.getAll();
	}

	/**
	 * Add a new category.
	 *
	 * @param category The category to add.
	 */
	public void addCategory(CategoryModel category) {
		// Call the create method of categoryDataService to add a new category
		categoryDataService.create(category);
	}

	/**
	 * Delete a category.
	 *
	 * @param category The category to delete.
	 */
	public void deleteCategory(CategoryModel category) {
		// Call the delete method of categoryDataService to delete a category
		categoryDataService.delete(category);
	}
}

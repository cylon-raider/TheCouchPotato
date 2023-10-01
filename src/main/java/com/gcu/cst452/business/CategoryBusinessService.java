/**
 * Service class for handling category-related business logic.
 * Provides methods for retrieving all categories, adding a category, and deleting a category.
 * It uses CategoryDataService to perform these operations.
 * <p>
 * Annotated with @Service to indicate that it's a service class.
 * Also, uses @Transactional for transaction management.
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
import org.springframework.transaction.annotation.Transactional;

@Service  // Indicates that this class is a service class
public class CategoryBusinessService {

	// Automatically wire the CategoryDataService
	@Autowired
	private CategoryDataService categoryDataService;

	/**
	 * Retrieve all categories.
	 * <p>
	 * This method calls the getAll method of categoryDataService to retrieve all categories.
	 *
	 * @return A list of all categories.
	 */
	public List<CategoryModel> getAllCategories() {
		// Call the getAll method of categoryDataService to retrieve all categories
		return categoryDataService.getAll();
	}

	/**
	 * Add a new category.
	 * <p>
	 * This method calls the create method of categoryDataService to add a new category.
	 * It is transactional, ensuring consistency in the event of an error.
	 *
	 * @param categoryModel The category model object to be added.
	 * @return A boolean indicating the success of the operation.
	 */
	@Transactional
	public boolean addCategory(CategoryModel categoryModel) {
		// Call the create method of categoryDataService to add a new category
		return categoryDataService.create(categoryModel);
	}

	/**
	 * Delete a category.
	 * <p>
	 * This method calls the delete method of categoryDataService to delete a category.
	 * It is transactional, ensuring consistency in the event of an error.
	 *
	 * @param categoryModel The category model object to be deleted.
	 * @return A boolean indicating the success of the operation.
	 */
	@Transactional
	public boolean deleteCategory(CategoryModel categoryModel) {
		// Call the delete method of categoryDataService to delete a category
		return categoryDataService.delete(categoryModel);
	}
}

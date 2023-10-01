/**
 * Represents a category model with its details.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModelProperty;

public class CategoryModel
{
	// Member Variables
	private Integer categoryId;

	// Validation and API documentation annotations for the category name
	@NotNull(message="Add a category to help users find products")
	@Size(min=1, max=32, message="Category name must be between 1 and 32 characters")
	@ApiModelProperty(value="Product Category", example="Apparel")
	private String categoryName;

	/**
	 * Default constructor.
	 */
	public CategoryModel() { }

	/**
	 * Constructor to initialize the CategoryModel object with provided category name.
	 *
	 * @param name The name of the category.
	 */
	public CategoryModel(String name) {
		this.categoryName = name;
	}

	/**
	 * Constructor to initialize the CategoryModel object with provided category ID and name.
	 *
	 * @param id The ID of the category.
	 * @param name The name of the category.
	 */
	public CategoryModel(int id, String name) {
		this.setCategoryId(id);
		this.categoryName = name;
	}

	/**
	 * Gets the category ID.
	 *
	 * @return The category ID.
	 */
	public Integer getCategoryId()
	{
		return categoryId;
	}

	/**
	 * Sets the category ID.
	 *
	 * @param categoryId The new category ID.
	 */
	public void setCategoryId(Integer categoryId)
	{
		this.categoryId = categoryId;
	}

	/**
	 * Gets the category name.
	 *
	 * @return The category name.
	 */
	public String getCategoryName()
	{
		return categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName The new category name.
	 */
	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}
}

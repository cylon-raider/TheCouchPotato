/**
 * Service class for handling product-related business logic.
 * Provides methods for adding, retrieving, updating, and deleting products,
 * as well as finding products by name.
 * It uses ProductDataService to perform these operations.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.business;

import com.gcu.cst452.data.ProductDataService;
import com.gcu.cst452.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service  // Indicates that this class is a service class
public class ProductBusinessService {

    @Autowired  // Automatically wire the ProductDataService
    private ProductDataService productDataService;

    /**
     * Add a new product.
     *
     * @param productModel The product to add.
     * @return true if the product was added successfully, false otherwise.
     */
    @Transactional  // Marks this method as transactional
    public boolean addProduct(ProductModel productModel){
        // Call the create method of productDataService to add a new product
        return productDataService.create(productModel);
    }

    /**
     * Retrieve all products.
     *
     * @return A list of all products.
     */
    public List<ProductModel> getAll() {
        // Call the getAll method of productDataService to retrieve all products
        return productDataService.getAll();
    }

    /**
     * Retrieve a product by its ID.
     *
     * @param productId The ID of the product to retrieve.
     * @return The product with the given ID.
     */
    public ProductModel getById(Integer productId) {
        // Call the getById method of productDataService to retrieve a product by its ID
        return productDataService.getById(productId);
    }

    /**
     * Update a product.
     *
     * @param productModel The product to update.
     * @return true if the product was updated successfully, false otherwise.
     */
    @Transactional  // Marks this method as transactional
    public boolean updateProduct(ProductModel productModel){
        // Call the update method of productDataService to update a product
        return productDataService.update(productModel);
    }

    /**
     * Delete a product.
     *
     * @param productModel The product to delete.
     * @return true if the product was deleted successfully, false otherwise.
     */
    @Transactional  // Marks this method as transactional
    public boolean deleteProduct(ProductModel productModel) {
        // Call the delete method of productDataService to delete a product
        return productDataService.delete(productModel);
    }

    /**
     * Find products by name, ignoring case.
     *
     * @param query The query string to search for in product names.
     * @return A list of products whose names contain the query string, ignoring case.
     */
    public List<ProductModel> findByNameContainingIgnoreCase(String query) {
        // Call the findByNameContainingIgnoreCase method of productDataService to find products by name
        return productDataService.findByNameContainingIgnoreCase(query);
    }
}

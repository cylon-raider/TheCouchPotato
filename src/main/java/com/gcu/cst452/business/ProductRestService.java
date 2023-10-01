/**
 * REST Controller for handling product-related requests.
 * Provides endpoints for retrieving a product by ID, retrieving all products,
 * and retrieving all products in JSON or XML format.
 * It uses ProductBusinessService to perform these operations.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.business;

import com.gcu.cst452.model.ProductList;
import com.gcu.cst452.model.ProductModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  // Indicates that this class is a REST controller
@RequestMapping("/service")  // Maps this controller to the specified URL path
public class ProductRestService {

    @Autowired  // Automatically wire the ProductBusinessService
    public ProductBusinessService service;

    /**
     * Retrieve a product by its ID.
     *
     * @param productId The ID of the product to retrieve.
     * @return A ResponseEntity containing the product or an error status.
     */
    @GetMapping(path="/getProduct/{id}")  // Maps this method to the specified URL path
    @ApiOperation(value = "Retrieve a product by ID")  // API operation annotation for Swagger documentation
    public ResponseEntity<?> getProduct(@PathVariable("id") Integer productId) {
        try {
            ProductModel product = service.getById(productId);
            if(product == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retrieve all products.
     *
     * @return A ResponseEntity containing the list of products or an error status.
     */
    @GetMapping("/allProducts")  // Maps this method to the specified URL path
    @ApiOperation(value = "Get all products")  // API operation annotation for Swagger documentation
    public ResponseEntity<?> getAllProducts() {
        try {
            List<ProductModel> products = service.getAll();
            if(products == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(products, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retrieve all products in JSON format.
     *
     * @return A list of all products.
     */
    @GetMapping(path="/getJson", produces={MediaType.APPLICATION_JSON_VALUE})  // Maps this method to the specified URL path and specifies the response type
    @ApiOperation(value = "Get all products in JSON format")  // API operation annotation for Swagger documentation
    public List<ProductModel> getProductsAsJson() {
        return service.getAll();
    }

    /**
     * Retrieve all products in XML format.
     *
     * @return A ProductList object containing all products.
     */
    @GetMapping(path="/getXml", produces ={MediaType.APPLICATION_XML_VALUE})  // Maps this method to the specified URL path and specifies the response type
    @ApiOperation(value = "Get all products in XML Format")  // API operation annotation for Swagger documentation
    public ProductList getProductAsXml() {
        ProductList productList = new ProductList();
        productList.setProductList(service.getAll());
        return productList;
    }
}

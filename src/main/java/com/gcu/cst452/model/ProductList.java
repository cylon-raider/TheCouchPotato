/**
 * Represents a list of products, used for XML representation.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

// Annotation to specify the root element for XML representation
@XmlRootElement(name="products")
public class ProductList
{
    // List to hold ProductModel objects
    private List<ProductModel> productList = new ArrayList<>();

    /**
     * Gets the list of products.
     *
     * @return The list of products.
     */
    // Annotation to specify the element name for XML representation
    @XmlElement(name="product")
    public List<ProductModel> getProductList()
    {
        return productList;
    }

    /**
     * Sets the list of products.
     *
     * @param products The new list of products.
     */
    public void setProductList(List<ProductModel> products)
    {
        this.productList = products;
    }
}

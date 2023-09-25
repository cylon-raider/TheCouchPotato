package com.gcu.cst452.business;

import com.gcu.cst452.data.ProductDataService;
import com.gcu.cst452.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductBusinessService {

    @Autowired
    private ProductDataService productDataService;

    @Transactional
    public boolean addProduct(ProductModel productModel){
        return productDataService.create(productModel);
    }
    public List<ProductModel> getAll() {
        return productDataService.getAll();
    }

    public ProductModel getById(Integer productId) {
        return productDataService.getById(productId);
    }

    @Transactional
    public boolean updateProduct(ProductModel productModel){
        return productDataService.update(productModel);
    }

    @Transactional
    public boolean deleteProduct(ProductModel productModel)
    {
        return productDataService.delete(productModel);
    }
    
	public List<ProductModel> findByNameContainingIgnoreCase(String query)
	{
		return productDataService.findByNameContainingIgnoreCase(query);
	}
}

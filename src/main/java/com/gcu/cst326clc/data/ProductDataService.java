package com.gcu.cst326clc.data;

import com.gcu.cst326clc.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDataService implements DataAccessInterface<ProductModel> {

    @SuppressWarnings("unused")
	@Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProductDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ProductModel> getAll() {
        String sql = "SELECT * FROM PRODUCT";
        List<ProductModel> products = new ArrayList<>();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
            while (srs.next()) {
                products.add(new ProductModel(srs.getInt("PRODUCT_ID"),
                        srs.getString("PRODUCT_NAME"),
                        srs.getString("PRODUCT_DESCRIPTION"),
                        srs.getFloat("PRODUCT_PRICE"),
                        srs.getInt("PRODUCT_QUANTITY")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public ProductModel getById(int id) {
        String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?";
        ProductModel product = new ProductModel();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, id);
            while (srs.next()){
                product.setProductId(id);
                product.setProductName(srs.getString("PRODUCT_NAME"));
                product.setProductDescription(srs.getString("PRODUCT_DESCRIPTION"));
                product.setProductPrice(srs.getFloat("PRODUCT_PRICE"));
                product.setProductQuantity(srs.getInt("PRODUCT_QUANTITY"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean create(ProductModel productModel) {
        String sql = "INSERT INTO PRODUCT(PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_PRICE, PRODUCT_QUANTITY) VALUES(?,?,?,?)";
        try {
            jdbcTemplate.update(sql, productModel.getProductName(), productModel.getProductDescription(),
                    productModel.getProductPrice(), productModel.getProductQuantity());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(ProductModel productModel) {
        String sql = "UPDATE PRODUCT SET PRODUCT_NAME = ?, PRODUCT_DESCRIPTION = ?, PRODUCT_PRICE = ?, PRODUCT_QUANTITY = ? WHERE PRODUCT_ID = ?";
        try {
            jdbcTemplate.update(sql, productModel.getProductName(), productModel.getProductDescription(),
                    productModel.getProductPrice(), productModel.getProductQuantity(), productModel.getProductId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(ProductModel productModel) {
        String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
        try {
            jdbcTemplate.update(sql, productModel.getProductId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

	public List<ProductModel> findByNameContainingIgnoreCase(String query)
	{		
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME LIKE ?";
		String sql2 = "SELECT * FROM PRODUCT WHERE PRODUCT_DESCRIPTION LIKE ?";
		Object[] args = { "%" + query + "%" };
		 List<ProductModel> products = new ArrayList<>();
	        try {
	            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, args);
	            while (srs.next()) {
	                products.add(new ProductModel(srs.getInt("PRODUCT_ID"),
	                        srs.getString("PRODUCT_NAME"),
	                        srs.getString("PRODUCT_DESCRIPTION"),
	                        srs.getFloat("PRODUCT_PRICE"),
	                        srs.getInt("PRODUCT_QUANTITY")));
	                
	                try {
	    	            SqlRowSet srs2 = jdbcTemplate.queryForRowSet(sql2, args);
	    	            while (srs2.next()) {
	    	                products.add(new ProductModel(srs2.getInt("PRODUCT_ID"),
	    	                		srs2.getString("PRODUCT_NAME"),
	    	                		srs2.getString("PRODUCT_DESCRIPTION"),
	    	                		srs2.getFloat("PRODUCT_PRICE"),
	    	                		srs2.getInt("PRODUCT_QUANTITY")));
	    	            }
	    	        } catch (Exception e) {
	    	            e.printStackTrace();
	    	        }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return products;
		
	}
}

/**
 * Service class for handling category data operations.
 * Implements DataAccessInterface for CategoryModel.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.data;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import com.gcu.cst452.model.CategoryModel;

@Service
public class CategoryDataService implements DataAccessInterface<CategoryModel>
{
    // DataSource object for database connectivity
    @SuppressWarnings("unused")
    @Autowired
    private DataSource dataSource;

    // JdbcTemplate object for executing SQL queries
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor to initialize dataSource and jdbcTemplate.
     *
     * @param dataSource The dataSource object for database connectivity.
     */
    public CategoryDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Retrieves all categories from the database.
     *
     * @return A list of CategoryModel objects.
     */
    @Override
    public List<CategoryModel> getAll()
    {
        String sql = "SELECT * FROM CATEGORY";
        List<CategoryModel> categories = new ArrayList<>();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
            while (srs.next()) {
                categories.add(new CategoryModel(srs.getInt("CATEGORY_ID"),
                        srs.getString("CATEGORY_NAME")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    /**
     * Retrieves a specific category by ID from the database.
     *
     * @param id The category ID.
     * @return A CategoryModel object.
     */
    @Override
    public CategoryModel getById(int id)
    {
        String sql = "SELECT * FROM CATEGORY WHERE CATEGORY_ID = ?";
        CategoryModel category = new CategoryModel();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, id);
            while (srs.next()){
                category.setCategoryId(id);
                category.setCategoryName(srs.getString("CATEGORY_NAME"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }

    /**
     * Creates a new category in the database.
     *
     * @param categoryModel The CategoryModel object.
     * @return A boolean indicating the success of the operation.
     */
    @Override
    public boolean create(CategoryModel categoryModel)
    {
        String sql = "INSERT INTO CATEGORY(CATEGORY_NAME) VALUES(?)";
        try {
            jdbcTemplate.update(sql, categoryModel.getCategoryName());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Update operation is not used in this service.
     *
     * @param categoryModel The CategoryModel object.
     * @return Always returns false.
     */
    @Override
    public boolean update(CategoryModel categoryModel)
    {
        // NOT USED !!!
        return false;
    }

    /**
     * Deletes a specific category from the database.
     *
     * @param categoryModel The CategoryModel object.
     * @return A boolean indicating the success of the operation.
     */
    @Override
    public boolean delete(CategoryModel categoryModel)
    {
        String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
        try {
            jdbcTemplate.update(sql, categoryModel.getCategoryId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

/**
 * Service class for handling cart data operations.
 * Implements DataAccessInterface for CartModel.
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
import com.gcu.cst452.model.CartModel;

@Service
public class CartDataService implements DataAccessInterface<CartModel>
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
	public CartDataService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Retrieves all cart data from the database.
	 *
	 * @return A list of CartModel objects.
	 */
	@Override
	public List<CartModel> getAll()
	{
		String sql = "SELECT * FROM CART";
		List<CartModel> cart = new ArrayList<>();
		try
		{
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while (srs.next())
			{
				cart.add(new CartModel(srs.getInt("USER_ID"), srs.getString("CONTENTS")));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return cart;
	}

	/**
	 * Retrieves a specific cart by user ID from the database.
	 *
	 * @param id The user ID.
	 * @return A CartModel object.
	 */
	@Override
	public CartModel getById(int id)
	{
		String sql = "SELECT * FROM CART WHERE USER_ID = ?";
		CartModel cart = new CartModel();
		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, id);
			while (srs.next()){
				cart.setUserId(id);
				cart.setItems(srs.getString("CONTENTS"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return cart;
	}

	/**
	 * Creates a new cart in the database.
	 *
	 * @param cart The CartModel object.
	 * @return A boolean indicating the success of the operation.
	 */
	@Override
	public boolean create(CartModel cart)
	{
		String sql = "INSERT INTO CART(USER_ID, CONTENTS) VALUES(?,?)";
		String cartContents = cart.ItemListToString();
		try
		{
			jdbcTemplate.update(sql, cart.getUserId(), cartContents);
		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Updates a specific cart in the database.
	 *
	 * @param cart The CartModel object.
	 * @return A boolean indicating the success of the operation.
	 */
	@Override
	public boolean update(CartModel cart)
	{
		String sql = "UPDATE CART SET CONTENTS = ? WHERE USER_ID = ?";
		String cartContents = cart.ItemListToString();
		try
		{
			jdbcTemplate.update(sql, cartContents, cart.getUserId());
		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Deletes a specific cart from the database.
	 *
	 * @param cart The CartModel object.
	 * @return A boolean indicating the success of the operation.
	 */
	@Override
	public boolean delete(CartModel cart)
	{
		String sql = "DELETE FROM CART WHERE USER_ID = ?";
		try {
			jdbcTemplate.update(sql, cart.getUserId());
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

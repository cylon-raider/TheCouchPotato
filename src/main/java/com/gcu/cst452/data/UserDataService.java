/**
 * Service class for handling user data operations.
 * Implements the DataAccessInterface for UserModel.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.data;

import com.gcu.cst452.model.LoginModel;
import com.gcu.cst452.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataService implements DataAccessInterface<UserModel> {

	// DataSource and JdbcTemplate for database operations
	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Constructor to initialize DataSource and JdbcTemplate.
	 *
	 * @param dataSource The data source for the JdbcTemplate.
	 * @param jdbcTemplate The JdbcTemplate for database operations.
	 */
	public UserDataService(DataSource dataSource, JdbcTemplate jdbcTemplate) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Retrieves all users from the database.
	 *
	 * @return A list of UserModel objects.
	 */
	@Override
	public List<UserModel> getAll() {
		String sql = "SELECT * FROM USER";
		List<UserModel> users = new ArrayList<>();
		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
			while (srs.next()) {
				users.add(new UserModel(srs.getInt("USER_ID"), srs.getString("FIRST_NAME"), srs.getString("LAST_NAME"),
						srs.getString("EMAIL"), srs.getString("PHONE_NUMBER"), srs.getString("USERNAME"),
						srs.getString("PASSWORD"), srs.getBoolean("IS_ACTIVE"), srs.getInt("ROLE")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * Retrieves a user by its ID.
	 *
	 * @param id The ID of the user to retrieve.
	 * @return A UserModel object.
	 */
	@Override
	public UserModel getById(int id) {
		String sql = "SELECT * FROM USER WHERE USER_ID = ?";
		UserModel user = new UserModel();
		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, id);
			while (srs.next()) {
				user.setUserId(srs.getInt("USER_ID"));
				user.setFirstName(srs.getString("FIRST_NAME"));
				user.setLastName(srs.getString("LAST_NAME"));
				user.setEmail(srs.getString("EMAIL"));
				user.setPhoneNumber(srs.getString("PHONE_NUMBER"));
				user.setUsername(srs.getString("USERNAME"));
				user.setPassword(srs.getString("PASSWORD"));
				user.setRoleId(srs.getInt("ROLE"));
				user.setActive(srs.getBoolean("IS_ACTIVE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * Creates a new user in the database.
	 *
	 * @param user The UserModel object to create.
	 * @return A boolean indicating the success of the operation.
	 */
	@Override
	public boolean create(UserModel user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		String sql = "INSERT INTO USER(FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, USERNAME, PASSWORD) VALUES (?,?,?,?,?,?)";
		try {
			int rowsAffected = jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(),
					user.getUsername(), hashedPassword);
			return rowsAffected > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Updates an existing user in the database.
	 *
	 * @param user The UserModel object to update.
	 * @return A boolean indicating the success of the operation.
	 */
	@Override
	public boolean update(UserModel user) {
		String sql = "UPDATE USER SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE_NUMBER = ?, USERNAME = ?, PASSWORD = ? WHERE USER_ID = ?";
		try {
			jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(),
					user.getUsername(), user.getPassword(), user.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Deletes a user from the database.
	 *
	 * @param userModel The UserModel object to delete.
	 * @return A boolean indicating the success of the operation.
	 */
	@Override
	public boolean delete(UserModel userModel) {
		String sql = "DELETE FROM USER WHERE USER_ID = ?";
		try {
			jdbcTemplate.update(sql, userModel.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Finds a user by username.
	 *
	 * @param username The username to search for.
	 * @return A LoginModel object.
	 */
	public LoginModel findByUsername(String username) {
		String sql = "SELECT * FROM USER WHERE USERNAME = ?";
		LoginModel loginModel = new LoginModel();
		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, username);
			while (srs.next()) {
				loginModel.setId(srs.getInt("USER_ID"));
				loginModel.setUsername(srs.getString("USERNAME"));
				loginModel.setPassword(srs.getString("PASSWORD"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginModel;
	}

	/**
	 * Retrieves user authority by username.
	 *
	 * @param username The username to search for.
	 * @return A UserModel object.
	 */
	public UserModel getUserAuthority(String username) {
		String sql = "SELECT * FROM USER WHERE USERNAME = ?";
		UserModel user = new UserModel();
		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, username);
			while (srs.next()) {
				user.setActive(srs.getBoolean("IS_ACTIVE"));
				user.setRoleId(srs.getInt("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * Retrieves user ID by username.
	 *
	 * @param username The username to search for.
	 * @return The user ID.
	 */
	public int getUserIdByUsername(String username) {
		String sql = "SELECT * FROM USER WHERE USERNAME = ?";
		int userId = 0;
		try {
			SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, username);
			while (srs.next()) {
				userId = srs.getInt("USER_ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}
}

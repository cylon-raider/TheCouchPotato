/**
 * Represents a user with various personal details.
 * Used for managing user information within the application.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {

    // Unique identifier for the user
    private int userId;

    // First name of the user
    @NotNull(message="First name is a required field")
    @Size(min=1, max=32, message="First name must be between 1 and 32 characters")
    private String firstName;

    // Last name of the user
    @NotNull(message="Last name is a required field")
    @Size(min=1, max=32, message="Last name must be between 1 and 32 characters")
    private String lastName;

    // Email of the user
    @NotNull(message="Email is a required field")
    @Size(min=1, max=32, message="Email must be between 1 and 32 characters")
    private String email;

    // Phone number of the user
    @NotNull(message="Phone Number is required")
    @Size(min=1, max=10, message="Phone Number must be between 1 and 10 characters")
    private String phoneNumber;

    // Username for account identification
    @NotNull(message="User name is a required field")
    @Size(min=1, max=32, message="User name must be between 1 and 32 characters")
    private String username;

    // Password for account security
    @NotNull(message="Password is a required field")
    @Size(min=1, max=32, message="Password must be between 1 and 32 characters")
    private String password;

    // Flag to indicate if the user is active
    private boolean isActive;

    // Role identifier for the user
    private int roleId;

    /**
     * Constructor for creating a new user with detailed information.
     *
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param email The email address of the user.
     * @param phoneNumber The phone number of the user.
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public UserModel(String firstName, String lastName, String email, String phoneNumber, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

    /**
     * Constructor for creating a new user with all information including user ID, active status, and role ID.
     *
     * @param userId The unique identifier for the user.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param email The email address of the user.
     * @param phoneNumber The phone number of the user.
     * @param username The username of the user.
     * @param password The password of the user.
     * @param isActive The active status of the user.
     * @param roleId The role identifier of the user.
     */
    public UserModel(int userId, String firstName, String lastName, String email, String phoneNumber, String username, String password, boolean isActive, int roleId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.roleId = roleId;
    }

    /**
     * Default constructor.
     */
    public UserModel() {
    }

    /**
     * Retrieves the first name of the user.
     *
     * @return A string representing the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName A string containing the first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the user.
     *
     * @return A string representing the last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName A string containing the last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the email of the user.
     *
     * @return A string representing the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email A string containing the email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the phone number of the user.
     *
     * @return A string representing the phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phoneNumber A string containing the phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Retrieves the username of the user.
     *
     * @return A string representing the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username A string containing the username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return A string representing the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password A string containing the password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checks if the user is active.
     *
     * @return A boolean indicating the active status of the user.
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets the active status of the user.
     *
     * @param active A boolean indicating the active status.
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Retrieves the role ID of the user.
     *
     * @return An integer representing the role ID.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the role ID of the user.
     *
     * @param roleId An integer containing the role ID.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Retrieves the user ID of the user.
     *
     * @return An integer representing the user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user ID of the user.
     *
     * @param userId An integer containing the user ID.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}

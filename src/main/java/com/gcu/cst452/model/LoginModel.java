/**
 * Represents a login model with user details for authentication.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {

    // Member Variables
    private int id;

    // Validation annotations for the username
    @NotNull(message="User name is a required field")
    @Size(min=1, max=32, message="User name must be between 1 and 32 characters")
    private String username;

    // Validation annotations for the password
    @NotNull(message="Password is a required field")
    @Size(min=1, max=32, message="Password must be between 1 and 32 characters")
    private String password;
    private boolean isActive;
    private int roleId;

    /**
     * Constructor to initialize the LoginModel object with provided username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Constructor to initialize the LoginModel object with provided details.
     *
     * @param id The ID of the user.
     * @param username The username of the user.
     * @param password The password of the user.
     * @param isActive The active status of the user.
     * @param roleId The role ID of the user.
     */
    public LoginModel(int id, String username, String password, boolean isActive, int roleId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.roleId = roleId;
    }

    /**
     * Default constructor.
     */
    public LoginModel(){
    }

    /**
     * Gets the username.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username The new username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password The new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the ID.
     *
     * @return The ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID.
     *
     * @param id The new ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Checks if the user is active.
     *
     * @return The active status.
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets the active status.
     *
     * @param active The new active status.
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Gets the role ID.
     *
     * @return The role ID.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the role ID.
     *
     * @param roleId The new role ID.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}

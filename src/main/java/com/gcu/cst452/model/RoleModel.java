/**
 * Represents a role with a specific role name.
 * Used for defining different roles within the application.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.model;

public class RoleModel {

    // Name of the role
    private String roleName;

    /**
     * Retrieves the name of the role.
     *
     * @return A string representing the role name.
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the name of the role.
     *
     * @param roleName A string containing the name of the role.
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

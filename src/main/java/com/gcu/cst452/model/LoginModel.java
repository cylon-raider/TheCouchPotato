package com.gcu.cst452.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {

    private int id;

    @NotNull(message="User name is a required field")
    @Size(min=1, max=32, message="User name must be between 1 and 32 characters")
    private String username;

    @NotNull(message="Password is a required field")
    @Size(min=1, max=32, message="Password must be between 1 and 32 characters")
    private String password;
    private boolean isActive;
    private int roleId;

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginModel(int id, String username, String password, boolean isActive, int roleId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.roleId = roleId;
    }

    public LoginModel(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }



}

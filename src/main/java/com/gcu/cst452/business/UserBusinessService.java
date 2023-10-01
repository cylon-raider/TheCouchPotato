/**
 * Service class for handling user-related business logic.
 * Implements UserDetailsService for integration with Spring Security.
 * Provides methods for creating a user and loading user details by username.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.business;

import com.gcu.cst452.data.UserDataService;
import com.gcu.cst452.model.LoginModel;
import com.gcu.cst452.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service  // Indicates that this class is a service
public class UserBusinessService implements UserDetailsService {

    @Autowired  // Automatically wire the UserDataService
    private UserDataService userDataService;

    /**
     * Constructor to initialize UserBusinessService with UserDataService.
     *
     * @param userDataService The data service for user operations.
     */
    public UserBusinessService(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    /**
     * Create a new user.
     *
     * @param userModel The model object containing user details.
     * @return true if user is created successfully, false otherwise.
     */
    public boolean createUser(UserModel userModel) {
        return userDataService.create(userModel);
    }

    /**
     * Load user details by username.
     * This method is used by Spring Security to authenticate users.
     *
     * @param username The username of the user.
     * @return A UserDetails object containing user details.
     * @throws UsernameNotFoundException if the username is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginModel user = userDataService.findByUsername(username);

        // Check if user details are valid
        if (user != null && user.getUsername() != null && !user.getUsername().isEmpty() && user.getPassword() != null && !user.getPassword().isEmpty()) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getUsername(), user.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("Username not found");
        }
    }

    /**
     * Retrieve user authority by username.
     *
     * @param username The username of the user.
     * @return A UserModel object containing user details and authority.
     */
    public UserModel getUserAuthority(String username) {
        return userDataService.getUserAuthority(username);
    }
}

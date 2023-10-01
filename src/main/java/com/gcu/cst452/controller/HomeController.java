/**
 * Controller class for handling requests to the home page.
 * Provides an endpoint for viewing the index page with a list of all products.
 * It also checks if the logged-in user is an admin and passes this information to the view.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.gcu.cst452.business.ProductBusinessService;
import com.gcu.cst452.business.UserBusinessService;
import com.gcu.cst452.model.ProductModel;
import com.gcu.cst452.model.UserModel;

@Controller
@RequestMapping("/")
public class HomeController {

    // Autowired services for user and product operations
    @Autowired
    private UserBusinessService userBusinessService;
    @Autowired
    private ProductBusinessService productBusinessService;

    /**
     * Displays the index page with a list of all products.
     * Checks if the logged-in user is an admin and passes this information to the view.
     *
     * @param user The current authenticated user.
     * @return A ModelAndView object for the index page.
     */
    @GetMapping("/index")
    public ModelAndView index(Principal user) {
        ModelAndView modelAndView = new ModelAndView();

        // Get the authority of the user to check if the user is an admin
        UserModel activeUser = userBusinessService.getUserAuthority(user.getName());
        boolean isAdmin = activeUser.isActive() && activeUser.getRoleId() == 1;

        // Add the admin status to the model
        modelAndView.addObject("isAdmin", isAdmin);

        // Get all products to display on the index page
        List<ProductModel> products = productBusinessService.getAll();

        // Add the products list to the model
        modelAndView.addObject("products", products);

        // Set the view name to index
        modelAndView.setViewName("index");

        return modelAndView;
    }
}

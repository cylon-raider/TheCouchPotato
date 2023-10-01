/**
 * Controller class for handling user registration requests.
 * Provides endpoints for displaying the registration form and handling the registration submission.
 * It uses the UserBusinessService to perform user registration.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.controller;

import com.gcu.cst452.business.UserBusinessService;
import com.gcu.cst452.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserBusinessService userBusinessService;

    /**
     * Displays the registration form.
     *
     * @return A ModelAndView object for the registration page.
     */
    @GetMapping("/")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView();
        UserModel userModel = new UserModel();
        modelAndView.addObject("title", "Registration Form");
        modelAndView.addObject("userModel", userModel);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    /**
     * Handles the registration submission.
     * Validates the user model, and if valid, attempts to create a new user.
     *
     * @param userModel The user model containing user details.
     * @param bindingResult The binding result for validation.
     * @param model The model to add attributes to.
     * @param redirectAttributes The redirect attributes to add flash attributes to.
     * @return A string indicating the view to redirect to.
     */
    @PostMapping("/register")
    public String register(@Valid UserModel userModel, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        // Check validation errors
        if(bindingResult.hasErrors()) {
            model.addAttribute("title", "Registration Form");
            return "registration";
        }
        // Attempt to create the user and handle the result
        if (userBusinessService.createUser(userModel)) {
            // If successful, add a success message and redirect to the login page
            redirectAttributes.addFlashAttribute("successMessage", "Registration successful! Please login.");
            return "redirect:/login";
        } else {
            // If failed, add an error message and return to the registration page
            model.addAttribute("errorMessage", "Registration failed. Please try again.");
            return "registration";
        }
    }
}

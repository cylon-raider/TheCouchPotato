package com.gcu.cst452.controller;

import com.gcu.cst452.business.UserBusinessService;
import com.gcu.cst452.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserBusinessService userBusinessService;

    @GetMapping({"/", "/login"})
    public ModelAndView displayLogin(@RequestParam(value= "error", required= false) String error, Model model){
        ModelAndView modelAndView = new ModelAndView();
        LoginModel loginModel = new LoginModel();
        modelAndView.addObject("title", "Login Form");
        modelAndView.addObject("loginModel", loginModel);
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid username or password.");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/doLogin")
    public ModelAndView loginUser(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {

        // Check for validation errors
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("title", "Login Form");
            modelAndView.addObject("loginModel", loginModel);
            modelAndView.setViewName("login");
            return modelAndView;
        }

        try {
            userBusinessService.loadUserByUsername(loginModel.getUsername());
            System.out.println("Login Successful");
            // If user details are successfully retrieved, redirect to the home page or dashboard
            return new ModelAndView("redirect:/index");  // redirect to the index page

        } catch (UsernameNotFoundException e) {
            model.addAttribute("errorMessage", "Invalid username or password.");
            return new ModelAndView("login");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An unexpected error occurred. Please try again.");
            return new ModelAndView("login");
        }
    }

}

package com.gcu.cst452.controller;

import com.gcu.cst452.business.UserBusinessService;
import com.gcu.cst452.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserBusinessService userBusinessService;

    @GetMapping("/")
    public ModelAndView display(){
        ModelAndView modelAndView = new ModelAndView();
        LoginModel loginModel = new LoginModel();
        modelAndView.addObject("title", "Login Form");
        modelAndView.addObject("loginModel", loginModel);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@ModelAttribute LoginModel loginModel, BindingResult bindingResult, Model model) {
        try {

            UserDetails userDetails = userBusinessService.loadUserByUsername(loginModel.getUsername());

            return new ModelAndView("redirect:/");
        } catch (UsernameNotFoundException e) {
            model.addAttribute("errorMessage", "User not registered. Please sign up.");
            return display(); // Redirect back to the login page with an error message
        }

    }
}

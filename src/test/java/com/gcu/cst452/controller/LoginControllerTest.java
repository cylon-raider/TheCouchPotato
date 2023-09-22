package com.gcu.cst452.controller;

import com.gcu.cst452.model.LoginModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest {

    private LoginController loginController;

    @BeforeEach
    void setUp() {
        loginController = new LoginController();
    }

    @Test
    void displayLogin() {
        // Mock the behavior of the Model and error param
        Model model = new BindingAwareModelMap();
        String error = null; // You can also test with "error" to simulate an error scenario

        // Call the displayLogin method
        ModelAndView modelAndView = loginController.displayLogin(error, model);

        // Assert the view name
        assertEquals("login", modelAndView.getViewName());

        // Assert the model attributes
        assertTrue(modelAndView.getModel().containsKey("title"));
        assertTrue(modelAndView.getModel().containsKey("loginModel"));

        assertEquals("Login Form", modelAndView.getModel().get("title"));
        assertTrue(modelAndView.getModel().get("loginModel") instanceof LoginModel);
    }
}


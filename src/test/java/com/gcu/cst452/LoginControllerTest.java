package com.gcu.cst452;

import com.gcu.cst452.controller.LoginController;
import com.gcu.cst452.model.LoginModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is used to test the LoginController class.
 * It performs unit testing on the displayLogin method of LoginController.
 */
public class LoginControllerTest {

    // Instance of LoginController to be tested
    private LoginController loginController;

    /**
     * This method is executed before each test.
     * It initializes the loginController object.
     */
    @BeforeEach
    void setUp() {
        loginController = new LoginController();
    }

    /**
     * This test method tests the displayLogin method of LoginController.
     * It checks whether the correct view is returned and the model contains the correct attributes.
     */
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

        // Assert the values of the model attributes
        assertEquals("Login Form", modelAndView.getModel().get("title"));
        assertTrue(modelAndView.getModel().get("loginModel") instanceof LoginModel);
    }
}

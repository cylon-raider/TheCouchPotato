/**
 * Controller for handling category-related requests.
 * Provides endpoints for viewing, adding, and deleting categories.
 * <p>
 * Annotated with @Controller to indicate that it's a controller class.
 * Also, uses @RequestMapping to map the URL path "/categories".
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.controller;

import com.gcu.cst452.business.CategoryBusinessService;
import com.gcu.cst452.business.UserBusinessService;
import com.gcu.cst452.model.CategoryModel;
import com.gcu.cst452.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller  // Indicates that this class is a controller class
@RequestMapping("/categories")  // Maps the URL path "/categories"
public class CategoryController {

    // Automatically wire the CategoryBusinessService
    @Autowired
    private CategoryBusinessService categoryBusinessService;

    // Automatically wire the UserBusinessService
    @Autowired
    private UserBusinessService userBusinessService;

    /**
     * Check if the user is an admin.
     *
     * @param user The current user.
     * @return A boolean indicating if the user is an admin.
     */
    private boolean isAdmin(Principal user) {
        UserModel activeUser = userBusinessService.getUserAuthority(user.getName());
        return activeUser.isActive() && activeUser.getRoleId() == 1;
    }

    /**
     * Display the categories page.
     *
     * @param user The current user.
     * @return The ModelAndView object for the categories page.
     */
    @GetMapping("/")
    public ModelAndView displayCategories(Principal user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Category Page");
        modelAndView.addObject("categories", categoryBusinessService.getAllCategories());
        modelAndView.addObject("isAdmin", isAdmin(user));
        modelAndView.setViewName("categories");
        return modelAndView;
    }

    /**
     * Display the add categories page.
     *
     * @param user The current user.
     * @return The ModelAndView object for the add categories page.
     */
    @GetMapping("/add")
    public ModelAndView displayAddCategories(Principal user){
        ModelAndView modelAndView = new ModelAndView();
        CategoryModel categoryModel = new CategoryModel();
        modelAndView.addObject("title", "Add Category Page");
        modelAndView.addObject("categoryModel", categoryModel);
        modelAndView.addObject("isAdmin", isAdmin(user));
        modelAndView.setViewName("addCategory");
        return modelAndView;
    }

    /**
     * Add a category.
     *
     * @param categoryModel The category model object to be added.
     * @param bindingResult The binding result object for validation.
     * @param model The model object.
     * @param user The current user.
     * @return The ModelAndView object for the categories page or add categories page.
     */
    @PostMapping("/addCategory")
    public ModelAndView addCategory(@Valid CategoryModel categoryModel, BindingResult bindingResult, Model model, Principal user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addCategory");
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Add Category Page");
            model.addAttribute("errorMessage", "Validation failed. Please check the entered values.");
            return modelAndView;
        }
        if(categoryBusinessService.addCategory(categoryModel)){
            return this.displayCategories(user);
        }else {
            return modelAndView;
        }
    }

    /**
     * Display the delete categories page.
     *
     * @param user The current user.
     * @return The ModelAndView object for the delete categories page.
     */
    @GetMapping("/delete")
    public ModelAndView displayDeleteCategories(Principal user){
        ModelAndView modelAndView = new ModelAndView();
        CategoryModel categoryModel = new CategoryModel();
        modelAndView.addObject("title", "Delete Category Page");
        modelAndView.addObject("categoryModel", categoryModel);
        modelAndView.addObject("isAdmin", isAdmin(user));
        modelAndView.setViewName("deleteCategory");
        return modelAndView;
    }

    /**
     * Delete a category.
     *
     * @param categoryModel The category model object to be deleted.
     * @param user The current user.
     * @return The ModelAndView object for the categories page or delete categories page.
     */
    @PostMapping("/deleteCategory")
    public ModelAndView deleteCategory(CategoryModel categoryModel, Principal user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteCategory");

        if(categoryBusinessService.deleteCategory(categoryModel))
        {
            return this.displayCategories(user);
        } else {
            return modelAndView;
        }
    }
}

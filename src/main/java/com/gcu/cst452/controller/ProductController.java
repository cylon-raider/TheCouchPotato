/**
 * Controller class for handling product-related requests.
 * Provides endpoints for displaying, adding, updating, deleting, and searching products.
 * It uses the UserBusinessService, ProductBusinessService, and CategoryBusinessService to perform various operations.
 *
 * @author Chris Markel
 * @version 1.0
 */
package com.gcu.cst452.controller;

import com.gcu.cst452.business.CategoryBusinessService;
import com.gcu.cst452.business.ProductBusinessService;
import com.gcu.cst452.business.UserBusinessService;
import com.gcu.cst452.model.ProductModel;
import com.gcu.cst452.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private UserBusinessService userBusinessService;

    @Autowired
    private ProductBusinessService productBusinessService;

    @Autowired
    private CategoryBusinessService categoryBusinessService;

    /**
     * Helper method to determine if the user is an admin.
     *
     * @param user The current user principal.
     * @return true if the user is an admin, false otherwise.
     */
    private boolean isAdmin(Principal user) {
        UserModel activeUser = userBusinessService.getUserAuthority(user.getName());
        return activeUser.isActive() && activeUser.getRoleId() == 1;
    }

    /**
     * Displays the product page.
     *
     * @param user The current user principal.
     * @return A ModelAndView object for the product page.
     */
    @GetMapping("/")
    public ModelAndView display(Principal user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Product Page");
        modelAndView.addObject("products", productBusinessService.getAll());
        modelAndView.addObject("isAdmin", isAdmin(user));
        modelAndView.setViewName("products");
        return modelAndView;
    }

    /**
     * Displays the Add Product Page.
     *
     * @param user The current user principal.
     * @return A ModelAndView object for the add product page.
     */
    @GetMapping("/add")
    public ModelAndView displayAddProducts(Principal user){
        ModelAndView modelAndView = new ModelAndView();
        ProductModel productModel = new ProductModel();
        modelAndView.addObject("title", "Add Product Page");
        modelAndView.addObject("productModel", productModel);
        modelAndView.addObject("categories", categoryBusinessService.getAllCategories());
        modelAndView.addObject("isAdmin", isAdmin(user));
        modelAndView.setViewName("addProduct");
        return modelAndView;
    }

    /**
     * Displays the Edit Product Page.
     *
     * @param user The current user principal.
     * @return A ModelAndView object for the edit product page.
     */
    @GetMapping("/update")
    public ModelAndView displayEditProducts(Principal user){
        ModelAndView modelAndView = new ModelAndView();
        ProductModel productModel = new ProductModel();
        modelAndView.addObject("title", "Edit Product Page");
        modelAndView.addObject("productModel", productModel);
        modelAndView.addObject("categories", categoryBusinessService.getAllCategories());
        modelAndView.addObject("isAdmin", isAdmin(user));
        modelAndView.setViewName("updateProduct");
        return modelAndView;
    }

    /**
     * Displays the Delete Product Page.
     *
     * @param user The current user principal.
     * @return A ModelAndView object for the delete product page.
     */
    @GetMapping("/delete")
    public ModelAndView displayDeleteProducts(Principal user){
        ModelAndView modelAndView = new ModelAndView();
        ProductModel productModel = new ProductModel();
        modelAndView.addObject("title", "Delete Product Page");
        modelAndView.addObject("productModel", productModel);
        modelAndView.addObject("isAdmin", isAdmin(user));
        modelAndView.setViewName("deleteProduct");
        return modelAndView;
    }

    /**
     * Handles the request to add a product.
     *
     * @param productModel The product model containing product details.
     * @param bindingResult The binding result for validation.
     * @param productCategory The product category.
     * @param model The model to add attributes to.
     * @param user The current user principal.
     * @return A ModelAndView object for the product page or add product page.
     */
    @PostMapping("/addProduct")
    public ModelAndView addProduct(@Valid ProductModel productModel, BindingResult bindingResult, String productCategory, Model model, Principal user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addProduct");
        productModel.setProductCategory(productCategory);
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Add Product Page");
            model.addAttribute("errorMessage", "Validation failed. Please check the entered values.");
            return modelAndView;
        }
        if(productBusinessService.addProduct(productModel)){
            return this.display(user);
        }else {
            return modelAndView;
        }
    }

    /**
     * Handles the request to update a product.
     *
     * @param productModel The product model containing product details.
     * @param bindingResult The binding result for validation.
     * @param productCategory The product category.
     * @param model The model to add attributes to.
     * @param user The current user principal.
     * @return A ModelAndView object for the product page or update product page.
     */
    @PostMapping("/updateProduct")
    public ModelAndView updateProduct(@Valid ProductModel productModel, BindingResult bindingResult, String productCategory, Model model, Principal user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateProduct");
        productModel.setProductCategory(productCategory);
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Update Product Page");
            model.addAttribute("errorMessage", "Validation failed. Please check the entered values.");
            return modelAndView;
        }
        if(productBusinessService.updateProduct(productModel)){
            return this.display(user);
        }else {
            return modelAndView;
        }
    }

    /**
     * Handles the request to delete a product.
     *
     * @param productModel The product model containing product details.
     * @param user The current user principal.
     * @return A ModelAndView object for the product page or delete product page.
     */
    @PostMapping("/deleteProduct")
    public ModelAndView deleteProduct(ProductModel productModel, Principal user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteProduct");

        if(productBusinessService.deleteProduct(productModel))
        {
            return this.display(user);
        } else {
            return modelAndView;
        }
    }

    /**
     * Handles the product search request.
     *
     * @param q The search query.
     * @param model The model to add attributes to.
     * @param user The current user principal.
     * @return A ModelAndView object for the search results page.
     */
    @GetMapping("/search")
    public ModelAndView showSearchForm(String q, Model model, Principal user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        List<ProductModel> products = productBusinessService.findByNameContainingIgnoreCase(q);
        modelAndView.addObject("isAdmin", isAdmin(user));
        model.addAttribute("title", "Product Search");
        model.addAttribute("products", products);
        return modelAndView;
    }
}

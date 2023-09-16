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

    // Helper method to determine if the user is an admin
    private boolean isAdmin(Principal user) {
        UserModel activeUser = userBusinessService.getUserAuthority(user.getName());
        return activeUser.isActive() && activeUser.getRoleId() == 1;
    }

    @GetMapping("/")
    public ModelAndView display(Principal user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Product Page");
        modelAndView.addObject("products", productBusinessService.getAll());
        modelAndView.addObject("isAdmin", isAdmin(user));  // Set isAdmin using the helper method
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView displayAddProducts(Principal user){
        ModelAndView modelAndView = new ModelAndView();
        ProductModel productModel = new ProductModel();
        modelAndView.addObject("title", "Add Product Page");
        modelAndView.addObject("productModel", productModel);
        modelAndView.addObject("categories", categoryBusinessService.getAllCategories());
        modelAndView.addObject("isAdmin", isAdmin(user));  // Set isAdmin using the helper method
        modelAndView.setViewName("addProduct");
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView displayEditProducts(Principal user){
        ModelAndView modelAndView = new ModelAndView();
        ProductModel productModel = new ProductModel();
        modelAndView.addObject("title", "Edit Product Page");
        modelAndView.addObject("productModel", productModel);
        modelAndView.addObject("categories", categoryBusinessService.getAllCategories());
        modelAndView.addObject("isAdmin", isAdmin(user));  // Set isAdmin using the helper method
        modelAndView.setViewName("updateProduct");
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView displayDeleteProducts(Principal user){
        ModelAndView modelAndView = new ModelAndView();
        ProductModel productModel = new ProductModel();
        modelAndView.addObject("title", "Delete Product Page");
        modelAndView.addObject("productModel", productModel);
        modelAndView.addObject("isAdmin", isAdmin(user));  // Set isAdmin using the helper method
        modelAndView.setViewName("deleteProduct");
        return modelAndView;
    }

    @PostMapping("/addProduct")
    public ModelAndView addProduct(@Valid ProductModel productModel, String productCategory, BindingResult bindingResult, Model model, Principal user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addProduct");
        productModel.setProductCategory(productCategory);
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Add Product Page");
            return modelAndView;
        }
        if(productBusinessService.addProduct(productModel)){
            return this.display(user);
        }else {
            return modelAndView;
        }
    }

    @PostMapping("/updateProduct")
    public ModelAndView updateProduct(@Valid ProductModel productModel, String productCategory, BindingResult bindingResult, Model model, Principal user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateProduct");
        productModel.setProductCategory(productCategory);
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Add Product Page");
            return modelAndView;
        }
        if(productBusinessService.updateProduct(productModel)){
            return this.display(user);
        }else {
            return modelAndView;
        }
    }

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

    @GetMapping("/search")
    public ModelAndView showSearchForm(@Valid String q, Model model, Principal user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        List<ProductModel> products = productBusinessService.findByNameContainingIgnoreCase(q);
        modelAndView.addObject("isAdmin", isAdmin(user));  // Set isAdmin using the helper method
        model.addAttribute("title", "Product Search");
        model.addAttribute("products", products);
        return modelAndView;
    }

}

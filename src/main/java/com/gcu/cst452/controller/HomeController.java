package com.gcu.cst326clc.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.gcu.cst326clc.business.ProductBusinessService;
import com.gcu.cst326clc.business.UserBusinessService;
import com.gcu.cst326clc.model.ProductModel;
import com.gcu.cst326clc.model.UserModel;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private UserBusinessService userBusinessService;
	
	@Autowired
	private ProductBusinessService productBusinessService;

    @GetMapping("/index")
    public ModelAndView index(Principal user){
        ModelAndView modelAndView = new ModelAndView();
        UserModel activeUser = userBusinessService.getUserAuthority(user.getName());
        boolean isAdmin = activeUser.isActive() && activeUser.getRoleId() == 1;
        modelAndView.addObject("isAdmin", isAdmin);
        List<ProductModel> products = productBusinessService.getAll();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}

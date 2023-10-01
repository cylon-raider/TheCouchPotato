/**
 * Controller class for handling cart-related requests.
 * Provides endpoints for viewing the cart, adding, deleting, incrementing, and decrementing items in the cart.
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.gcu.cst452.business.CartBusinessService;
import com.gcu.cst452.business.UserBusinessService;
import com.gcu.cst452.model.CartItem;
import com.gcu.cst452.model.UserModel;

@Controller
@RequestMapping("/cart")
public class CartController {

	// Autowired services for user and cart operations
	@Autowired
	private UserBusinessService userBusinessService;
	@Autowired
	private CartBusinessService cartBusinessService;

	/**
	 * Displays the cart page with all cart items and total calculations.
	 *
	 * @param user The current authenticated user.
	 * @return A ModelAndView object for the cart page.
	 */
	@GetMapping("/")
	public ModelAndView display(Principal user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Cart Page");
		List<CartItem> items = cartBusinessService.getCartItemsByUsername(user.getName());
		modelAndView.addObject("items", items);

		// Calculate and add cart totals to the model
		double subTotal = cartBusinessService.calculateSubTotal(items);
		double tax = cartBusinessService.calculateTax(subTotal);
		double total = cartBusinessService.calculateTotal(subTotal, tax);
		modelAndView.addObject("cartSubTotal", subTotal);
		modelAndView.addObject("cartTax", tax);
		modelAndView.addObject("cartTotal", total);

		UserModel activeUser = userBusinessService.getUserAuthority(user.getName());
		boolean isAdmin = activeUser.isActive() && activeUser.getRoleId() == 1;
		modelAndView.addObject("isAdmin", isAdmin);
		modelAndView.setViewName("cart");
		return modelAndView;
	}

	/**
	 * Adds an item to the cart.
	 *
	 * @param productId The ID of the product to add.
	 * @param user The current authenticated user.
	 * @return A RedirectView object to redirect to the cart page.
	 */
	@GetMapping("/addItem")
	public RedirectView addItemToCart(@RequestParam int productId, Principal user) {
		try {
			cartBusinessService.addItem(user.getName(), productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/cart/");
		return redirectView;
	}

	/**
	 * Deletes an item from the cart.
	 *
	 * @param productId The ID of the product to delete.
	 * @param user The current authenticated user.
	 * @return A RedirectView object to redirect to the cart page.
	 */
	@GetMapping("/deleteItem")
	public RedirectView deleteItem(@RequestParam int productId, Principal user) {
		try {
			cartBusinessService.deleteItem(user.getName(), productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/cart/");
		return redirectView;
	}

	/**
	 * Decrements the quantity of an item in the cart.
	 *
	 * @param productId The ID of the product to decrement.
	 * @param itemQty The current quantity of the item.
	 * @param user The current authenticated user.
	 * @return A RedirectView object to redirect to the cart page.
	 */
	@GetMapping("/decrementItem")
	public RedirectView decrementItem(@RequestParam int productId, @RequestParam int itemQty, Principal user) {
		try {
			if (itemQty - 1 == 0) {
				cartBusinessService.deleteItem(user.getName(), productId);
			} else {
				cartBusinessService.updateItem(user.getName(), productId, itemQty - 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/cart/");
		return redirectView;
	}

	/**
	 * Increments the quantity of an item in the cart.
	 *
	 * @param productId The ID of the product to increment.
	 * @param itemQty The current quantity of the item.
	 * @param user The current authenticated user.
	 * @return A RedirectView object to redirect to the cart page.
	 */
	@GetMapping("/incrementItem")
	public RedirectView incrementItem(@RequestParam int productId, @RequestParam int itemQty, Principal user) {
		try {
			cartBusinessService.updateItem(user.getName(), productId, itemQty + 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/cart/");
		return redirectView;
	}
}

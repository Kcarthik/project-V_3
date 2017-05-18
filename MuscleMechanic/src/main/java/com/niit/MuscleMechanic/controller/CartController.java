package com.niit.MuscleMechanic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.MuscleMechanic.DAO.CartDAO;
import com.niit.MuscleMechanic.DAO.CustomerDAO;
import com.niit.MuscleMechanic.model.Cart;
import com.niit.MuscleMechanic.model.Customer;
import com.niit.MuscleMechanic.model.Users;

@Controller
public class CartController {
	
	
	@Autowired
	CartDAO cartDao;
	
	@Autowired 
	CustomerDAO customerDAO;
	
	
	public  CartController(){
		
		System.out.println("Instantiating CartController");
		
	}

	@RequestMapping("/cart/getCartId")
	public String getCartId(Model model) {
		Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Customer customer = customerDAO.getCustomerByUsername(username);
		Cart cart = customer.getCart();
		int cartId = cart.getId();
		model.addAttribute("cartId", cartId);
		return "cart";
	}

	@RequestMapping("/cart/getCart/{cartId}")
	public @ResponseBody Cart getCart(@PathVariable int cartId) {
		Cart cart = cartDao.getCart(cartId);
		return cart;
	}
	
}


package com.niit.MuscleMechanic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.MuscleMechanic.DAO.CustomerDAO;
import com.niit.MuscleMechanic.model.Category;
import com.niit.MuscleMechanic.model.Customer;


@Controller
public class CustomerController {
    @Autowired
    CustomerDAO custDAO;
    
    public CustomerController()
    {
    	System.out.println("Instantiating CustomerController");
    }
	
    
    @RequestMapping("/all/customer/showCustomer")
    public String showCategory(Model model)
	{
		model.addAttribute("customer",new Customer());
		return "signup";
	}
    
    @RequestMapping("/all/customer/addCustomer")
    
    public String addProduct(@Valid @ModelAttribute(value = "customer")  Customer cust,BindingResult result,Model model,HttpServletRequest request) 
	{
		
		if (result.hasErrors()){
		
			return "signup";
		}
 
		try{
		custDAO.saveCustomer(cust);
		}
catch(Exception e)
{
	model.addAttribute("duplicateUsername","Username already exists. Please enter different username");
	System.out.println("Exception is"+e.getMessage());
	
}
		 return "redirect:/";
    }
      	
}

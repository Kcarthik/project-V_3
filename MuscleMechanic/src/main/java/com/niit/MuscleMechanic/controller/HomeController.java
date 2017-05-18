package com.niit.MuscleMechanic.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {

	@Autowired
	SessionFactory sessionFactory;
	public HomeController() {
		System.out.println("Instantiating home controller");
	}
 		@RequestMapping("/") 
 		public String home(){
 			
 			return "index";
 		}


@RequestMapping("/login")
public String login(@RequestParam (value="error",required=false)String error,@RequestParam(value="logout",required=false)String logout,Model model){	
	if(error!=null)
	model.addAttribute("error","Invalid username and password... Please enter the correctly");
	if(logout!=null)
		model.addAttribute("logout", "logout successfully");
	
	return "login";
}


}
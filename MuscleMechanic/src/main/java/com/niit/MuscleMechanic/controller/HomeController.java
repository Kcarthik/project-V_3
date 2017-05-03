package com.niit.MuscleMechanic.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



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
}

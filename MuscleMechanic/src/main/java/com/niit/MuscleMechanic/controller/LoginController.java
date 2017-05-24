package com.niit.MuscleMechanic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	
	public LoginController()
	
	{
		System.out.println("Instantiating logincontroller");
	}
	
	
//	@RequestMapping("/login")
//	public String LoginPage()
//	{
//		return "login";
//	}
//
//	@RequestMapping("/login_session-attributes")
//	public String LoginCheck(HttpSession session, Model m)
//	{
//		String Username = SecurityContextHolder.getContext().getAuthentication().getName();
//		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//		System.out.println("User Name"+Username);
//		session.setAttribute("username", Username);
//		String role="USER_ROLE";
//		String page="";
//		session.setAttribute("LoggedIn", true);
//		for (GrantedAuthority authority : authorities)
//		{
//			System.out.println(authority.getAuthority());
//			
//			if (authority.getAuthority().equals(role))
//			{
//				page="SuccessPage";
//			}
//			else
//			{
//				page="product";
//			}
//			
//		}
//		return page;
//		
//	}
	
	@RequestMapping("/login")
	public String login(@RequestParam (value="error",required=false)String error,@RequestParam(value="logout",required=false)String logout,Model model){	
		if(error!=null)
		model.addAttribute("error","Invalid username and password... Please enter them correctly");
		if(logout!=null)
			model.addAttribute("logout", "logout successfully");
		
		return "login";
	}
	
	
}

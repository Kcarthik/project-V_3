package com.niit.MuscleMechanic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.MuscleMechanic.DAO.CategoryDAO;
import com.niit.MuscleMechanic.model.Category;


@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	public CategoryController()
	{
		System.out.println("Instantiating CategoryController ");
	}
	
	@RequestMapping("/admin/category/showCategory")
	public String showCategory(Model model)
	{
		model.addAttribute("category",new Category());
		return "addCategoryForm";
	}
	@RequestMapping("/admin/category/addCategory")
	public String addCategory(@ModelAttribute("category")Category cat)
	{
		categoryDAO.insert(cat);
		return "addCategoryForm";
		
	}
	
	@RequestMapping("/all/category/getAllCategory")
	public String displayAllCaygory(Model model)
	{
		List<Category> cat=categoryDAO.getAllCategories();
		model.addAttribute("categorylist", cat);
		return "categoryList";
		
	}
	@RequestMapping("/admin/category/deleteCategory")
	 public String deleteCategory(@PathVariable int id)
	 {
		categoryDAO.delete(id);
		return "redirect:/all/category/getAllCategory";
		
	 }


}


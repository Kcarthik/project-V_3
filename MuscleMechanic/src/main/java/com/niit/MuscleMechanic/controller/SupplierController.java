package com.niit.MuscleMechanic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.MuscleMechanic.DAO.SupplierDAO;
import com.niit.MuscleMechanic.model.Supplier;


@Controller
public class SupplierController {
	
	@Autowired
	SupplierDAO supDao;
	
	public SupplierController()
	{
		System.out.println("Instantiating SupplierController");
	}
	
	@RequestMapping("/admin/supplier/showSupplier")
	public String showSupplier(Model model)
	{
		model.addAttribute("supplier", new Supplier());
		return "addSupplierForm";
	}
	
	@RequestMapping("/admin/supplier/addSupplier")
	public String addSupplier(@ModelAttribute(value="Supplier")Supplier supp)
	{
		supDao.insert(supp);
		return "addSupplierForm";
	}
	
	@RequestMapping("/all/supplier/getAllSupplier")
	public String displayAllSuppliers(Model model)
	{
		List<Supplier> supp=supDao.getAllSuppliers();
		model.addAttribute("supplierlist",supp);
		return "supplierlist";
	}
	
	@RequestMapping("/admin/supplier/deleteSupplier/{id}")
	public String deleteSupplier(@PathVariable int id)
	{
		supDao.delete(id);
		return "redirect:/all/supplier/getAllSupplier";
	}
	
	
	

}
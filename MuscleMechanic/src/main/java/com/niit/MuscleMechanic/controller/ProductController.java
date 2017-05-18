package com.niit.MuscleMechanic.controller;



import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.MuscleMechanic.DAO.CategoryDAO;
import com.niit.MuscleMechanic.DAO.ProductDAO;
import com.niit.MuscleMechanic.model.Product;

@Controller
public class ProductController {

	/*
	 * Mapping the product form
	 * 
	 */

	@Autowired
	ProductDAO productDao;
	
	@Autowired
	CategoryDAO categoryDao;

	

	
	public ProductController(){
		System.out.println("Instantiating ProductController");
	}
	
//	@RequestMapping(value = "/getAllproducts")
//	public ModelAndView getAllProducts() {
//		ModelAndView mv = new ModelAndView("product");
//		mv.addObject("productlist", productDao.retrieve());
//		mv.addObject("productdata", product);
//
//		return mv;
//
//	}

	@RequestMapping(value = "/admin/product", method = RequestMethod.GET)
	public String show(Model model) {
		model.addAttribute("productlist", productDao.retrieve());
		model.addAttribute("categories", categoryDao.getAllCategories());

		model.addAttribute("productdata", new Product());
		
		return "product";
	}

	@RequestMapping(value = "/admin/product.do", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("productdata") Product product, BindingResult result, Model model,HttpServletRequest request) 
	{
		System.out.println("Product Called");
		if(result.hasErrors())
		{
			model.addAttribute("productlist", productDao.retrieve());
		
			return "product";
		}
		productDao.insert(product);
		
		MultipartFile file = product.getFile();
		/*if (!prodImage.isEmpty()) {
		Path paths = Paths
				.get("C:/Users/Carmelina Fernando/git/Project_v3/PetStore/src/main/webapp/resources/images/"
						+ prod.getId() + ".png");
		System.out.println(paths.toString());
		try {
			prodImage.transferTo(new File(paths.toString()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
		
		
		if (file != null && file.getSize() > 0) {

			String originalFile = file.getOriginalFilename();
			String filePath = request.getSession().getServletContext().getRealPath("/resources/images/productimages/");
			System.out.println(filePath + "" + originalFile);

			String myFileName = filePath + product.getId() + ".jpg";

			try {
				byte imagebyte[] = product.getFile().getBytes();
				BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(myFileName));
				fos.write(imagebyte);
				fos.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	
		
		return "redirect:/admin/product";

	}
	
	@RequestMapping("/admin/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id,Model model)

	{
		model.addAttribute("productdata",new Product());
		productDao.delete(id);
		return "redirect:/admin/product";
	}

	@RequestMapping("/admin/product/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model model)

	{
		Product product = productDao.getProductData(id);
		model.addAttribute("productdata", product);
		return "singleProductPage";
	}
	
	
	
	@RequestMapping("/admin/product/editProduct/{id}")
	public String editProduct(@PathVariable int id, @ModelAttribute("productdata") Product product,Model model)
	{
		 product = productDao.getProductData(id);
		model.addAttribute("productdata",product);
		model.addAttribute("productlist",productDao.retrieve());
		productDao.updateProduct(product);
		return "product";
	}

	

}

package com.niit.MuscleMechanic.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.niit.MuscleMechanic.DAO.ProductDAO;
import com.niit.MuscleMechanic.model.Product;



@Controller
public class ProductController {
	@Autowired
	ProductDAO prodDao;

	public ProductController() {
		System.out.println("Instantiating ProductController");

	}

	@RequestMapping("/admin/product/showProduct")

	public String showProduct(Model model) {
		model.addAttribute("product", new Product());
		
		return "addProductForm";

	}

	@RequestMapping("/admin/product/addProduct")

	public String addProduct(@Valid @ModelAttribute(value = "product")  Product prod,BindingResult result,Model model,HttpServletRequest request) 
	{
		
		if (result.hasErrors()){
		
			return "addProductForm";
		}
		
		
		prodDao.insert(prod);
		
		
		MultipartFile file =prod.getFile();
//		if (!prodImage.isEmpty()) {
//			Path paths=
//	Paths.get("/Users/karthikcs/Desktop/MuscleMechanic/MuscleMechanic/src/main/webapp/resources/images"+ prod.getId()+".png");
//		try {
//			prodImage.transferTo(new File(paths.toString()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		
//		}
//		
//		}
		
		if (file != null && file.getSize()>0 )
		{
			String originalFile=file.getOriginalFilename();
			String filePath=request.getSession().getServletContext().getRealPath("/resources/images/productimages/");
			System.out.println(filePath +""+originalFile);
			String myFileName= filePath + prod.getId()+ ".jpg";
			
			try
			{
				byte imagebyte[]=prod.getFile().getBytes();
				BufferedOutputStream fos= new BufferedOutputStream(new FileOutputStream(myFileName));
				fos.write(imagebyte);
				fos.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return "redirect:/admin/product/showProduct";
	}

	@RequestMapping("/all/product/getAllProduct")
	public String displayAllProducts(Model model) {
		List<Product> prod = prodDao.retrieve();
		model.addAttribute("productlist", prod);
		return "productList";
	}

	@RequestMapping("/admin/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id,Model model)

	{
		model.addAttribute("product",new Product());
		prodDao.delete(id);
		return "redirect:/all/product/getAllProduct";
	}

	@RequestMapping("/admin/product/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model model)

	{
		Product p = prodDao.getProductData(id);
		model.addAttribute("product", p);
		return "viewProduct";
	}
	
	@RequestMapping("/admin/product/editProduct/{id}")
	public String editProduct(@PathVariable int id,@ModelAttribute("productdata") Product product, Model model)
	{
		Product p = prodDao.getProductData(id);
		model.addAttribute("product", p);
		prodDao.updateProduct(product);
		return "redirect:/admin/product/showProduct";
	}

}
package com.niit.MuscleMechanic.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MuscleMechanic.DAO.ProductDAO;
import com.niit.MuscleMechanic.model.Product;


public class ProductTestCase {
	@Autowired
    static AnnotationConfigApplicationContext context;

@Autowired
	static Product product;
	
	@Autowired
	
	static ProductDAO prodDao;
	

	
	@BeforeClass
	public static void initialize()
	{    product = new Product();
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.MuscleMechanic");
		context.refresh();
		prodDao=(ProductDAO) context.getBean("prodDao");
		product=context.getBean(Product.class);
		
	}
	

	@Test
	public void insertTestCase()
	{
		product.setId(1);
		product.setDescription("During Workout");
		product.setName("Muscle mechanic");
		product.setPrice(2500);
		product.setQuantity(3);
		
		boolean flag= prodDao.insert(product);
	    assertEquals("",true,flag);
	}
	
	
	@Test
	public void deleteTestCase()
	{
	}
	
}

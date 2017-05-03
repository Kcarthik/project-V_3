package com.niit.MuscleMechanic.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MuscleMechanic.DAO.CategoryDAO;
import com.niit.MuscleMechanic.model.Category;

public class CategoryTest {
	@Autowired
    static AnnotationConfigApplicationContext context;

@Autowired
	static Category category;
	
	@Autowired
	static
	CategoryDAO categoryDAO;
	
	
	@BeforeClass
	public static void initialize()
	{   category = new Category();
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.MuscleMechanic");
		context.refresh();
		
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		
		category=context.getBean(Category.class);
		
	}
	
	@Test
	public void insertTestCase()
	{
		category.setId(1);
		category.setCategoryName("PreWorkout");
		category.setCategoryDetails("Used before workout");
		
		boolean flag= categoryDAO.insert(category);
	    assertEquals("",true,flag);
	}
	
}

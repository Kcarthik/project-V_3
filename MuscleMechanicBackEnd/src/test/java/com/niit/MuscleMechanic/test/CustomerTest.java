//package com.niit.MuscleMechanic.test;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.MuscleMechanic.DAO.CustomerDAO;
//import com.niit.MuscleMechanic.model.Customer;
//
//public class CustomerTest {
// @Autowired 
// static AnnotationConfigApplicationContext context;
// 
// @Autowired
//static Customer customer;
// 
// @Autowired 
//static CustomerDAO customerDAO;
// 
// @BeforeClass
// public static void initialize()
// {
//	customer = new Customer();
//	 context = new AnnotationConfigApplicationContext();
//	 context.scan("com.niit.MuscleMechanic");
//		context.refresh();
//		
//		customerDAO=(CustomerDAO) context.getBean("customerDAO");
//		
//		customer=context.getBean(Customer.class);
//		
//			 
// }
// 
// 
// 
// 
// @Test
// public void insertTestCase()
// {
//customer.setId(1);
//customer.setFirstname("prince");
//customer.setLastname("Vegeta");
//customer.setPhonenumber("8553859889");
//customer.setEmail("Karushaker12@gmail.com");
//boolean flag= customerDAO.saveCustomer(customer);
//assertEquals("",true,flag);
//
//	}
// }
// 
//

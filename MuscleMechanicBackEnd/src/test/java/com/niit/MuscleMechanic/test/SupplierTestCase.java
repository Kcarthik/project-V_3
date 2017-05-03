package com.niit.MuscleMechanic.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MuscleMechanic.DAO.SupplierDAO;
import com.niit.MuscleMechanic.model.Supplier;

public class SupplierTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Supplier supplier;

	@Autowired
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		supplier = context.getBean(Supplier.class);

	}

	@Test
	public void insertTestCase() {
		supplier.setId(1);
		supplier.setSupplierAddress("HSBR layout,hebbal");
		supplier.setSupplierName("Muscle mechanic");
		boolean flag = supplierDAO.insert(supplier);
		assertEquals("", true, flag);
	}

	@Test
	public void deleteTestCase() {
	}

}

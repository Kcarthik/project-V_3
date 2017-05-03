package com.niit.MuscleMechanic.DAO;

import java.util.List;

import com.niit.MuscleMechanic.model.Supplier;

public interface SupplierDAO 

	{
		public  boolean insert(Supplier ob);
		public List<Supplier> getAllSuppliers();
		public boolean delete(int supid);
		
	}

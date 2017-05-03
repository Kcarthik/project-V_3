package com.niit.MuscleMechanic.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MuscleMechanic.model.Supplier;

@Repository("supplierDAO")
@Transactional

public class SupplierDAOimpl implements SupplierDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public boolean insert(Supplier ob) {
		try
		{
			
		Session session = sessionFactory.openSession();
		session.save(ob);
		session.flush();
		session.close();
		System.out.println("supplier value Inserted");
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
		return true;
	}

	public List<Supplier> getAllSuppliers() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> suppliers=query.list();
		return suppliers;
	}

	public boolean delete(int supid) {
		try{
			
		
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class, supid);
		session.delete(supplier);
		session.flush();
		session.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
		//System.out.println("Supplier Deleted");
		
	}

}

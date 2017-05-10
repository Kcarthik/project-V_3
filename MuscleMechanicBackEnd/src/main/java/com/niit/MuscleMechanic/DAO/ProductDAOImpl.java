package com.niit.MuscleMechanic.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.MuscleMechanic.model.Product;
@Repository("prodDao")
@Transactional

public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean insert(Product ob) {
		try{
			
		Session session = sessionFactory.openSession();
		session.save(ob);
		session.flush();
		session.close();
	
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	//	System.out.println("product Inserted");
		
	}

	public void delete(int prodid) {
		Session session = sessionFactory.openSession();
		Product ob = (Product) session.get(Product.class, prodid);
		session.delete(ob);
		session.flush();
		session.close();
		System.out.println("Product Deleted");
	}

	

	@SuppressWarnings("unchecked")
	public List<Product> retrieve() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Product");
		List<Product> ob =  q.list();
		return ob;
	}

	public Product getProductData(int prodid) {

		return (Product) sessionFactory.openSession().get(Product.class, prodid);

	}

	public void updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		
		session.update(product);
		System.out.println("Product Updated");
	}

}




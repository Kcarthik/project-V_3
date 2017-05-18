package com.niit.MuscleMechanic.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MuscleMechanic.model.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

//	public ProductDAOImpl(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	public boolean insert(Product product) {
		try {
			// sessionFactory.getCurrentSession().persist(product);
			Session session = sessionFactory.openSession();

			session.beginTransaction();

			session.save(product);
			session.getTransaction().commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Product> retrieve() {

		return sessionFactory.openSession().createQuery("From Product").list();
	}

	public void delete(int prodid) {
		Session session = sessionFactory.openSession();
		Product ob = (Product) session.get(Product.class, prodid);
		session.delete(ob);
		session.flush();
		session.close();
		System.out.println("Product Deleted");
		
	}

	

	public Product getProductData(int prodid) {

		return (Product) sessionFactory.openSession().get(Product.class, prodid);

	}

	public void updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		//Product prod = (Product) session.get(Product.class, id);
		session.update(product);
		System.out.println("Product Updated");
	}

}



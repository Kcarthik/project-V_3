package com.niit.MuscleMechanic.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.MuscleMechanic.model.Cart;
import com.niit.MuscleMechanic.model.CustomerOrder;

public class CustomerOrderDAOImpl implements CustomerOrderDAO {
 @Autowired

 private SessionFactory sessionFactory;
 
 
	public void getCustomerOrder(Cart cart) {
		CustomerOrder customerOrder=new CustomerOrder();
		customerOrder.setCart(cart);
		customerOrder.setCustomer(cart.getCustomer());
		customerOrder.setBillingAddress(cart.getCustomer().getBillingAddress());
		customerOrder.setShippingAddress(cart.getCustomer().getShippingAddress());
		//Insert the data in CustomerOrder table
		Session session=sessionFactory.openSession();
		session.save(customerOrder);
		
	}

}

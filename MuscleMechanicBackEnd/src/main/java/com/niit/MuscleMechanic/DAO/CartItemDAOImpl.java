package com.niit.MuscleMechanic.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import com.niit.MuscleMechanic.model.Cart;
import com.niit.MuscleMechanic.model.CartItem;

@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO{

	
	@Autowired
private SessionFactory sessionFactory;

	

	public void addCartItem(CartItem cartItem) {
		   Session session=sessionFactory.openSession();
		   session.saveOrUpdate(cartItem);
		   session.flush();
		   session.close();	
		}

	public void deleteCartItem(CartItem cartItem) {
		Session session = sessionFactory.openSession();
		session.delete(cartItem);
		session.flush();
		session.close();
		
		
	}

	public void removeAllCartItem(Cart cart) {
		List<CartItem> cartItems=cart.getCartItems();
		//JDK 1.5 feature - for each loop
		for(CartItem cartItem:cartItems){
		deleteCartItem(cartItem);
		}
		
	}

	public CartItem getCartItem(int cartItemId) {
		Session session=sessionFactory.openSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
		session.flush();
		session.close();
		return cartItem;
	}

}

package com.niit.MuscleMechanic.DAO;

import com.niit.MuscleMechanic.model.Cart;
import com.niit.MuscleMechanic.model.CartItem;

public interface CartItemDAO {

	 CartItem getCartItem(int cartItemid );
	 void addCartItem(CartItem cartItem);
	 void deleteCartItem(CartItem cartItem);
	 void removeAllCartItem(Cart cart);
}

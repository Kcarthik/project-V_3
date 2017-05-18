package com.niit.MuscleMechanic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.MuscleMechanic.DAO.CartDAO;
import com.niit.MuscleMechanic.DAO.CartItemDAO;
import com.niit.MuscleMechanic.DAO.CustomerDAO;
import com.niit.MuscleMechanic.DAO.ProductDAO;
import com.niit.MuscleMechanic.model.Cart;
import com.niit.MuscleMechanic.model.CartItem;
import com.niit.MuscleMechanic.model.Customer;
import com.niit.MuscleMechanic.model.Product;
import com.niit.MuscleMechanic.model.Users;

@Controller
public class CartItemController {

	
	@Autowired
	private CartItemDAO cartItemDao;
	
	@Autowired
	private CustomerDAO customerDao;
	
	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	private CartDAO cartDao;
	
	
	
	
	public CartItemController()
	{
		System.out.println("Instantiating CartItem Controller");
	}
	
	@RequestMapping("/cart/addCartItem/{pid}")
	@ResponseStatus(value= HttpStatus.NO_CONTENT)
   public void addCartItem(@PathVariable(value="pid")int productId)
   {
		Users users= (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   String username = users.getUsername();
   Customer customer = customerDao.getCustomerByUsername(username);
   Cart cart= customer.getCart();
   List<CartItem> cartItems=cart.getCartItems();
   
   Product product = productDao.getProductData(productId);
   
   
   for(int i=0; i<cartItems.size(); i++)
   {
	   CartItem cartItem = cartItems.get(i);
	   Product p=cartItem.getProduct();
	   
	   if(p.getId()==productId)
	   {
		   cartItem.setQuantity(cartItem.getQuantity()+1);
		   cartItem.setTotalPrice(cartItem.getQuantity()* p.getQuantity());//update the total price
		   cartItemDao.addCartItem(cartItem);//update the quantity in the cartitem
		   return;
	   }
   }
   
   CartItem cartItem = new CartItem();
   cartItem.setQuantity(1);
   cartItem.setTotalPrice(cartItem.getQuantity() * product.getPrice());
   cartItem.setProduct(product);//set product id
   cartItem.setCart(cart);//set cart id
   cartItemDao.addCartItem(cartItem);//insert query
	
}
	
	
	@RequestMapping("/cart/removeCartItem/{cartItemId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeCartItem(@PathVariable int cartItemId)
	{
	CartItem cartItem=cartItemDao.getCartItem(cartItemId);
	cartItemDao.deleteCartItem(cartItem);
	}
	
	
	@RequestMapping("/cart/removeAllCartItems/{cartId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeAllCartItems(@PathVariable int cartId)
	{
	Cart cart=cartDao.getCart(cartId);
	cartItemDao.removeAllCartItem(cart);
	}
	
}

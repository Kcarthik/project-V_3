package com.niit.MuscleMechanic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity

public class CustomerOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Orderid;
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name="billingAddress_id")
	private BillingAddress billingAddress;
	
	@OneToOne
	@JoinColumn(name="shippingAddress_id")
	private ShippingAddress shippingAddress;
	


public ShippingAddress getShippingAddress() {
	return shippingAddress;
}

public void setShippingAddress(ShippingAddress shippingAddress) {
	this.shippingAddress = shippingAddress;
}

public int getOrderid() {
	return Orderid;
}

public void setOrderid(int orderid) {
	Orderid = orderid;
}

public BillingAddress getBillingAddress() {
	return billingAddress;
}

public void setBillingAddress(BillingAddress billingAddress) {
	this.billingAddress = billingAddress;
}

public Cart getCart() {
	return cart;
}

public void setCart(Cart cart) {
	this.cart = cart;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

	
	
}

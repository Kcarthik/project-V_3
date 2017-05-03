package com.niit.MuscleMechanic.DAO;
import java.util.List; 

import com.niit.MuscleMechanic.model.Product;

public interface ProductDAO {


	public boolean insert(Product ob);

	public void delete(int prodid);

	public List<Product> retrieve();

	public Product getProductData(int prodid);

	public void updateProduct(Product product);

}
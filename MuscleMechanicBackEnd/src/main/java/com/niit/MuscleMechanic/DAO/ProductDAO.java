package com.niit.MuscleMechanic.DAO;

import com.niit.MuscleMechanic.model.Product;
import java.util.*;

public interface ProductDAO {
	
	public boolean insert(Product product);
	public void delete(int prodid);

	public List<Product> retrieve();

	public Product getProductData(int prodid);

	public void updateProduct(Product product );


}

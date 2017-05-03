package com.niit.MuscleMechanic.DAO;

import java.util.List;

import com.niit.MuscleMechanic.model.Category;


public interface CategoryDAO {
	
	public boolean insert(Category ob);
	public List<Category> getAllCategories();
	public void delete(int catid);
	
	/*

	public Category getCategoryData(int catid);

	public void updateCategory(int id);
*/

}




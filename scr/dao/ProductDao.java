package dao;

import java.util.List;


import model.Product;



public interface ProductDao {
		//create-->void
		void add(Product product);
		
		
		//read-->List
		List<Product> selectAll();
		List<Product> selectMenu();
		List<Product> selectById(int id);
		List<Product> selectByNumber(String number);
		List<Product> selectByName(String name);
		String newNumber();
		//update-->void
		void update(Product product);
		
		//delete-->void
		void delete(int id);

}

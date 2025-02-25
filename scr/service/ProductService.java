package service;

import java.util.List;

import model.Product;



public interface ProductService {
		//create
		void add(Product product);	
		
		//read
		String All();
		String[][] AllEx();
		List<Product>readAll();
		List<Product>readMenu();
		Product findById(int id);
		Product findByNumber(String number);
		Product findByName(String name);
		String productNumber();
		
		//update
		void update(Product product);
		void updateInventory(int inventory, String number);
		//delete
		void delete(int id);
		
		
}

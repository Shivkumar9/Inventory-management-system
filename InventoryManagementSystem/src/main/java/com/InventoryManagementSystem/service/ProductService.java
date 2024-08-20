package com.InventoryManagementSystem.service;

import java.util.List;

import com.InventoryManagementSystem.entity.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	
	public Product saveProduct(Product product);
	
	public Product getById(int id);
	
	public void deleteById(int id);  
}

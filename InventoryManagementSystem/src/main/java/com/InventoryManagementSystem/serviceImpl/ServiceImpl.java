package com.InventoryManagementSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InventoryManagementSystem.entity.Product;
import com.InventoryManagementSystem.service.ProductService;

@Service
public class ServiceImpl implements ProductService{

	@Autowired
	com.InventoryManagementSystem.repo.ProductRepo ProductRepo;
	
	@Override
	public List<Product> getAllProducts() {

		List<Product> product= ProductRepo.findAll();
		return product;
	}

	@Override
	public Product saveProduct(Product product) {
		return ProductRepo.save(product);
	}

	@Override
	public Product getById(int id) {
		return ProductRepo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		
		ProductRepo.deleteById(id);
	}

	
}

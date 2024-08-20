package com.InventoryManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.InventoryManagementSystem.entity.Product;
import com.InventoryManagementSystem.service.ProductService;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private ProductService service;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/products")
	public String getAllProducts(Model model) {

		model.addAttribute("products", service.getAllProducts());

		return "products";
	}

	@GetMapping("products/new")
	public String createProduct(Model model) {

		Product product = new Product();
		model.addAttribute("product", product);

		return "create-product";
	}
	
	@PostMapping("/products")
	public String saveProduct(@ModelAttribute ("products") Product product) {
		
		service.saveProduct(product);
		
		return "redirect:/products";
	}
	
	@GetMapping("/products/edit/{id}")
	public String editProduct(@PathVariable int id, Model model) {
		
		model.addAttribute("product", service.getById(id));
		
		return "edit_product";
	}
	
	@PostMapping("/products/edit/{id}")
	public String updateProduct(@PathVariable int id, @ModelAttribute("product") Product product) {
		
		Product existingProduct= service.getById(id);
		
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		
		service.saveProduct(existingProduct);
		
		return "redirect:/products";
	}
	
	@GetMapping("/products/{id}")
	public String deleteById(@PathVariable int id) {
		
		service.deleteById(id);
		
		return "redirect:/products";
	}

}

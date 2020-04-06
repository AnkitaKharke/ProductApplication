package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entities.Product;

import com.example.repos.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository repo;

	@RequestMapping("/getProducts")
	@GetMapping
	public Iterable<Product> getProducts() {
		return repo.findAll();

	}

	@PostMapping
	@RequestMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product) {
		return repo.save(product);
	}

	@DeleteMapping
	@RequestMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
	
	
	@PutMapping
	@RequestMapping("/updateProduct/{id}")
	public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
	return repo.save(product);
	}

}

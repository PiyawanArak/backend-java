package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/product")
	public List<Product> getEmployee() {
		return productRepository.findAll();
	}

	@PostMapping("/product")
	public Product addEmployee(@RequestBody Product body) {
		
			return productRepository.save(body);
	}
	
//	@GetMapping("/productSearch")
//	public List<Product> getSearchDetail(@RequestParam String productName, @RequestParam String productDetail) {
//		
//		Optional <Product> product =  productRepository.findByProductNameAndProductDetail();
//		return null;
//	}
	
	
	@PutMapping("/product/{productId}")
	public Product updatEmployee(@PathVariable Integer productId, @RequestBody Product body) {

Optional<Product> product = productRepository.findById(productId);
		
		if(product.isPresent()) {
			
			Product productEdit = product.get();
			
			productEdit.setProductName(body.getProductName());
			productEdit.setProductPrice(body.getProductPrice());
			productEdit.setProductAmount(body.getProductAmount());
			productEdit.setProductDetail(body.getProductDetail());
			
			productRepository.save(productEdit);
			
			return productEdit;
			
		}else {
			
			return null;
		}
	}

	@DeleteMapping("/product/{productId}")
	public String deletEmployee(@PathVariable Integer productId) {
		
		Optional<Product> product = productRepository.findById(productId);

		if( product.isPresent()) {
			productRepository.delete(product.get());
			return "Delete done";
		}else {
			return "Not found";
		}
	}

}

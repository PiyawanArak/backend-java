package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;

@RestController
public class ProductController {

	private List<Product> data = new ArrayList<Product>();
	
	@GetMapping("/product")
	public List<Product> getEmployee() {
		return data;
	}

	@PostMapping("/product")
	public Product addEmployee(@RequestBody Product body) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getProductID() == body.getProductID()) {
				return null;
			}
		}

		data.add(body);
		return body;
	}
	
	@GetMapping("/productSearch")
	public List<Product> getSearchDetail(@RequestParam String productName, @RequestParam String productDetail) {
		List<Product> found = new ArrayList<Product>();

		for (int i = 0; i < data.size(); i++) {
			
			if (data.get(i).getProductName().contains(productName) && productName != ""
					|| data.get(i).getProductDetail().contains(productDetail) && productDetail != "" ) {
				
				 found.add(data.get(i));
			}
			
		}

		return found;
	}
	
	@PutMapping("/product/{productId}")
	public Product updatEmployee(@PathVariable Integer productId, @RequestBody Product body) {

		for (int i = 0; i < data.size(); i++) {
			if (productId == data.get(i).getProductID()) {
				data.get(i).setProductName(body.getProductName());
				data.get(i).setProductPrice(body.getProductPrice());
				data.get(i).setProductAmount(body.getProductAmount());
				data.get(i).setProductDetail(body.getProductDetail());

				return data.get(i);
			}
		}

		return null;
	}

	@DeleteMapping("/product/{productId}")
	public String deletEmployee(@PathVariable Integer productId) {

		for (int i = 0; i < data.size(); i++) {
			if (productId == data.get(i).getProductID()) {
				data.remove(i);
				return "Delete sucess";
			}
		}
		return "Employee not found";
	}

}

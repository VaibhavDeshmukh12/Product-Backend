package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.services.ProductService;

@CrossOrigin(origins = "https://product-front-end-kappa.vercel.app/")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/saveProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

		return new ResponseEntity<>(this.productService.saveProduct(product), HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") int id) {
		return new ResponseEntity<>(this.productService.getProductById(id), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllProduct() {
		return new ResponseEntity<>(this.productService.getAllProduct(), HttpStatus.OK);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
		return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.NO_CONTENT);
	}

	@PostMapping("/edit/{id}")
	public ResponseEntity<?> editProduct(@RequestBody Product product, @PathVariable("id") int id) {
		return new ResponseEntity<>(productService.editProduct(product, id), HttpStatus.CREATED);
	}
}

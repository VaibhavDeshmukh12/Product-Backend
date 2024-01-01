package com.product.services;

import java.util.List;


import com.product.model.Product;

public interface ProductService {
	public Product saveProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(int id);
	
	public String deleteProduct(int id);
	
	public Product editProduct(Product product,int id);
}

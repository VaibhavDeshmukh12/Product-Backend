package com.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Product;
import com.product.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public Product saveProduct(Product product) {
		Product prod = productRepo.save(product);
		return prod;
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return productRepo.findById(id).get();
	}

	@Override
	public String deleteProduct(int id) {
		
		Product product = productRepo.findById(id).get();
		
		if(product != null) {
			productRepo.delete(product);
			return "Product Delete Successfully";
		}
		return "Something wrong on server";
		
	}

	@Override
	public Product editProduct(Product product, int id) {
		Product oldProduct = productRepo.findById(id).get();
		oldProduct.setPname(product.getPname());
		oldProduct.setStatus(product.getStatus());
		oldProduct.setPrice(product.getPrice());
		oldProduct.setDescription(product.getDescription());
		return productRepo.save(oldProduct);
	}

}

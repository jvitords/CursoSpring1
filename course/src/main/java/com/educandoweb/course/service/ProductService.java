package com.educandoweb.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> encontrarProdutos(){
		List<Product> products = productRepository.findAll();
		return products;
	}
	
	public Optional<Product> findById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product;
	}
}

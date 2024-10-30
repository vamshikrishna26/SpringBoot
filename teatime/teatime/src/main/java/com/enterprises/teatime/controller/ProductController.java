package com.enterprises.teatime.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enterprises.teatime.entity.Products;
import com.enterprises.teatime.jparepo.ProductRepo;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepo productRepo; 
	
	@PostMapping("/createProducts")
	public ResponseEntity<Products> createProducts(@RequestBody Products products) {
		return new ResponseEntity<>(productRepo.save(products),HttpStatus.CREATED);	
	}
	
	@GetMapping("/getProducts")
	public ResponseEntity<List<Products>> getProducts(){
		return new ResponseEntity<>(productRepo.findAll(),HttpStatus.CONTINUE);
		
	}
	
	@GetMapping("/getProducts/{productId}")
	public Optional<Products> getProducts(@PathVariable("productId") int productId){
		return productRepo.findById(productId);
			
	}
	
	@PutMapping("/getProducts/updateProducts/{productId}")
	public ResponseEntity<Products> updateProducts(@PathVariable("productId") int productId,@RequestBody Products pro){
		Optional<Products> checkProduct=productRepo.findById(productId);
		if(checkProduct.isPresent()) {
			checkProduct.get().setProductId(pro.getProductId());
			checkProduct.get().setProductName(pro.getProductName());
			checkProduct.get().setCostPrice(pro.getCostPrice());
			checkProduct.get().setSellPrice(pro.getSellPrice());
			checkProduct.get().setAvaliability(pro.isAvaliability());
			return new ResponseEntity<>(productRepo.save(checkProduct.get()),HttpStatus.CONTINUE);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/getProducts/deleteProduct/{productId}")
	public ResponseEntity<Void> deleteProducts(@PathVariable("productId") int productId){
		Optional<Products> checkProduct=productRepo.findById(productId);
		if(checkProduct.isPresent()) {
			productRepo.deleteById(productId);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}

}

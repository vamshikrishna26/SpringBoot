package com.enterprises.teatime.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprises.teatime.entity.Products;

public interface ProductRepo extends JpaRepository<Products, Integer> {

}

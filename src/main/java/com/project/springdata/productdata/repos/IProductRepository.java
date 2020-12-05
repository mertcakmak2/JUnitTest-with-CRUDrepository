package com.project.springdata.productdata.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.springdata.productdata.Entities.Product;

public interface IProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findByName(String string);
	List<Product> findByNameAndDesc(String name, String desc);
	List<Product> findByPriceGreaterThan(Double price);
	List<Product> findByDescContains(String price);
	List<Product> findByPriceBetween(Double price1, Double price2);
	List<Product> findByDescLike(String desc);
	List<Product> findByIdIn(int ids []);
}

package com.project.springdata.productdata.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.springdata.productdata.Entities.Product;

public interface IProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findByName(String string);

}

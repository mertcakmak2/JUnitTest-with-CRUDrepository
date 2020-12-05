package com.project.springdata.productdata;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.springdata.productdata.Entities.Product;
import com.project.springdata.productdata.repos.IProductRepository;

@SpringBootTest
class ProductdataApplicationTests {
	
	@Autowired
	IProductRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(2);
		product.setName("IWatch");
		product.setDesc("from samsung");
		product.setPrice(1500d);
		
		repository.save(product);
	}
	
	@Test
	public void testRead() {
		Product product = repository.findById(1).get();
		System.out.print(product.getDesc());
	}
	
	@Test
	public void testUpdate() {
		Product product = repository.findById(1).get();
		product.setPrice(1200d);
		repository.save(product);
	}
	
	@Test
	public void testCount() {
		System.out.println(repository.count());
	}
	
	@Test
	public void testFindByName() {
		List<Product> products = repository.findByName("Iphone");
		products.forEach(p -> System.out.println(p.getPrice()));
	}
	
	@Test
	public void testDelete() {
		if(repository.existsById(1)) {
			System.out.println("deleting a product");
			repository.deleteById(1);			
		}
		
	}

}

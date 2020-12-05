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
		product.setId(1);
		product.setName("Iwatch");
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
	public void testDelete() {
		if(repository.existsById(1)) {
			System.out.println("deleting a product");
			repository.deleteById(1);			
		}
		
	}

	@Test
	public void testFindByName() {
		List<Product> products = repository.findByName("Iwatch");
		products.forEach(p -> System.out.println(p.getPrice()));
	}
	
	@Test
	public void testFindByNameAndDesc() {
		List<Product> products = repository.findByNameAndDesc("Iwatch", "from samsung");
		products.forEach(p -> System.out.println(p.getPrice()));
	}
	
	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = repository.findByPriceGreaterThan(900d);
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testfindByDescContains() {
		List<Product> products = repository.findByDescContains("sung");
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testfindByPriceBetween() {
		List<Product> products = repository.findByPriceBetween(1400d,1600d);
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testfindByDescLike() {
		List<Product> products = repository.findByDescLike("%om%");
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testfindByIdIn() {
		int sayilar [] = {2,3};
		List<Product> products = repository.findByIdIn(sayilar);
		products.forEach(p -> System.out.println(p.getName()));
	}
}

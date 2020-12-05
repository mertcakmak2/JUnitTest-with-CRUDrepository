package com.project.springdata.productdata.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@GetMapping("/getProduct")
	public String getProduct() {
		return "Get Product Endpoint";
	}

}

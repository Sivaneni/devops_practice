package com.ImplementRest.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.ImplementRest.demo.entities.Product;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class Demo2ApplicationTests {

	@Value("${productservice.url}")
	private String BASE_URL;
	@Test
	void testGetProduct() {
		System.out.println("base url is "+BASE_URL);
		RestTemplate temp=new RestTemplate();
		
		Product product = temp.getForObject(BASE_URL+"/1", Product.class);
		assertNotNull(product);
		assertEquals("goat", product.getName());
		
	}
	
	@Test
	void testCreateProduct() {
		
		RestTemplate temp=new RestTemplate();
		
		Product product2 = new Product();
		product2.setName("toy");
		product2.setDescription("kids toy");
		product2.setPrice(25689);
		Product response = temp.postForObject(BASE_URL, product2, Product.class);
		assertNotNull(response);
		assertNotNull(response.getId());
		
	}

}

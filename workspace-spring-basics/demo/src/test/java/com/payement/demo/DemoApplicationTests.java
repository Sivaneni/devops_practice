package com.payement.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.payement.demo.service.PayementService;
import com.payement.demo.service.PayementServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {
	@Autowired
	PayementServiceImpl service;

	@Test
	void testdepedencyinjection() {
		
		assertNotNull(service.getDao());
	}

}

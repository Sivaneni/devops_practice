package com.springdatajpa.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdatajpa.demo.Repos.StudentRepository;
import com.springdatajpa.demo.entities.Student;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class Demo1ApplicationTests {
	@Autowired
	private StudentRepository repository;

	@Test
	void testsavestudent() {
		
		Student student = new Student();
		student.setId(1L);
		student.setName("sivaneni");
		student.setTestScore(256);
		repository.save(student);
		
		Student savedstudent = repository.findById(1L).get();
		assertNotNull(savedstudent);
	}

}

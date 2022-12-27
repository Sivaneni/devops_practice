package com.springdatajpa.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.demo.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

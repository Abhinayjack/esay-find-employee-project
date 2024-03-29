package com.project.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.Employee;

@Repository
public interface empRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findBySkill(String skill);
	 
	 

}

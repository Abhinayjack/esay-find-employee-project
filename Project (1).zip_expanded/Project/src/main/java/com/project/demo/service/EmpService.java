package com.project.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.entity.Employee;
import com.project.demo.repository.empRepo;

@Service
public class EmpService {
	@Autowired
	private empRepo repo;
public void addEmp(Employee e) {
	repo.save(e);
}
public List<Employee> getAllEmp(){
	return repo.findAll();
}

public Employee getEmpById(int id) {
	Optional<Employee> e=repo.findById(id);
	if(e.isPresent()) {
		return e.get();
	}
	return null;
}

public List<Employee> getEmpBySkill(String skill) {
    return repo.findBySkill(skill);
}


public void deleteEmp(int id) {
	 repo.deleteById(id);;
}

}

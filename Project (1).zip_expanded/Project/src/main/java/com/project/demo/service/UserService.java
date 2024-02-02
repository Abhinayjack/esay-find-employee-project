package com.project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.demo.entity.User;
import com.project.demo.repository.UserRepo;


@Service
public class UserService {
	@Autowired
	private UserRepo repo;
public void addUser(User e) {
	repo.save(e);
}

public User authenticateUser(String mob, String pass) {
    return repo.findByMobAndPass(mob, pass).orElse(null);
}

}

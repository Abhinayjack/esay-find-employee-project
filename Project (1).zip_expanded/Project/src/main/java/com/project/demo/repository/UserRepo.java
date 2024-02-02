package com.project.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	 Optional<User> findByMobAndPass(String mob, String pass);
}

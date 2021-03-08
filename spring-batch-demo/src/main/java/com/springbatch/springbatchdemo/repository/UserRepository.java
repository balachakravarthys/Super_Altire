package com.springbatch.springbatchdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbatch.springbatchdemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	List<User> findByDept(String dept);

}

package com.springbatch.springbatchdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbatch.springbatchdemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

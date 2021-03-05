package com.example.demo.repository;
import com.example.demo.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
public interface StudentRepository extends JpaRepository<Student,Integer>{
	  
}

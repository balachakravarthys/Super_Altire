package com.springbatch.springbatchdemo.batch;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.springbatch.springbatchdemo.model.User;
import com.springbatch.springbatchdemo.repository.UserRepository;

public class DBReader implements ItemReader<User> {
	@Autowired
	private UserRepository userRepository;
	 private int nextStudentIndex;
	
	
	
	@Override
	public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		List<User> user  = userRepository.findAll();
		User users = null;
		
		if (nextStudentIndex < user.size()) {
			users = user.get(nextStudentIndex);
            nextStudentIndex++;
        }
        else {
            nextStudentIndex = 0;
        }
		
		return  users;
	}

}

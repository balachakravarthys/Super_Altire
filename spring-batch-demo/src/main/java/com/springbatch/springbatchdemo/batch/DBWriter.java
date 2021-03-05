package com.springbatch.springbatchdemo.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springbatch.springbatchdemo.model.User;
import com.springbatch.springbatchdemo.repository.UserRepository;

@Component
public class DBWriter implements ItemWriter<User> {
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void write(List<? extends User> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Data Saved User : "+ items);
		userRepository.saveAll(items);
	}

}

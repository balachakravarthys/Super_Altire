package com.springbatch.springbatchdemo;

import static org.mockito.Mockito.when;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import com.springbatch.springbatchdemo.Controller.FilesController;
import com.springbatch.springbatchdemo.service.FilesStorageService;
import com.springbatch.springbatchdemo.service.LoadService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBatchDemoApplicationTests {
	/*
	 * @Autowired private UserRepository userRepository;
	 * 
	 * @Autowired private UserService userService;
	 */
	@InjectMocks
	FilesController fileController;
	@Mock
	FilesStorageService storageService;

	@Mock
	LoadService loadService;

	@Test
	public void uploadFileTest() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
			JobRestartException, JobInstanceAlreadyCompleteException {
		FileSystemResource file  = new FileSystemResource("uploads/users.csv");
		File fi = file.getFile();
		
		//when(storageService.save((MultipartFile) fi)).thenReturn();
		when(loadService.load()).thenReturn(BatchStatus.COMPLETED);
	}
	
	

	/*
	 * @Test public void testSaveExample() { // User user =new
	 * User(1,"Mithran","001","12000"); // userRepository.save(user);
	 * 
	 * User user1 = new User(2, "bala", "Accounts", "2000");
	 * 
	 * List<User> userMithran = userRepository.findAll().stream().filter(c ->
	 * c.getName().startsWith("b")) .collect(Collectors.toList());
	 * assertThat(userMithran).hasSize(1);
	 * 
	 * System.out.println("Getting data from Database : " + user1);
	 * 
	 * assertEquals(user1.getName(), userMithran.get(0).getName());
	 * assertEquals(user1.getDept(), userMithran.get(0).getDept()); }
	 */

}

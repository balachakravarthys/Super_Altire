package com.example.demo.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.Student;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	public StudentRepository studentRepository;

	  
	  
	  @GetMapping("/students") 
	  public List<Student> getAllStudents() { 
		 List<Student>  list = studentRepository.findAll();
		 
		  return  studentRepository.findAll(); }
	 
	  @GetMapping("/students/{id}")
	    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") int studentId)
	        throws ResourceNotFoundException {
		
	        Student student = studentRepository.findById(studentId)
	          .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
	   
	        return ResponseEntity.ok().body(student);
	    }
	    
	    @PostMapping("/students")
	    public Student createStudent(@Valid @RequestBody Student student) {
	    	
	    	
	    	student  = gettotal(student);
	    	
	    	  List<Student> studentList = Arrays.asList(student);
		       // List<Optional<Student>> studentResponse =  Arrays.asList(studentRepository.findById(studentId));
	    	  student = getPassORfail(studentList,student);
		        
		        student.setCreate_Date(new Date());
		    	student.setCreate_User("Admin");
	    	
	        return studentRepository.save(student);
	    }
	    
	    public Student getPassORfail(List studentList,Student student) {
	    	  boolean isPass = false; 
	    	 Predicate < Student > studentFilterPredicate = new Predicate < Student > () {
		            @Override
		            public boolean test(Student student) {
		                return  student.getTamil() > 35 && student.getEnglish() > 35 && student.getMaths() > 35
		                		&& student.getPhysics() >35 && student.getSocialscience()>35;
		            }
		        };
				/*
				 * List < Student > studentAList = studentList.stream()
				 * .filter(studentFilterPredicate) .collect(Collectors.toList());
				 */
		       
		        Student stud = (Student) studentList.stream()
		        	    .filter(studentFilterPredicate)
		        	    .findAny()
		        	    .orElse(null);
		        if(stud!=null) {
		        	isPass = true;
		        	student.setPassORfail("Pass");
		        }else {
		        	student.setPassORfail("fail");
		        }
		        
		        return student;
	    }

	    @PutMapping("/students/{id}")
	    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") int studentId,
	         @Valid @RequestBody Student studentDetails) throws ResourceNotFoundException {
	        Student student = studentRepository.findById(studentId)
	        .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
	      //  student.setTotal(studentDetails.getTotal());
	        List<Student> studentList = Arrays.asList(student);
	        student.setName(studentDetails.getName());
	        student.setTamil(studentDetails.getTamil());
	        student.setEnglish(studentDetails.getEnglish());
	        student.setMaths(studentDetails.getMaths());
	        student.setPhysics(studentDetails.getPhysics());
	        student.setSocialscience(studentDetails.getSocialscience());
	        student.setUpdate_Date(new Date());
	        student.setUpdate_User("Admin");
	        student  = gettotal(student);
	        student.setTotal(student.getTotal());
	        student = getPassORfail(studentList,student);
	        final Student updatedStudent = studentRepository.save(student);
	        return ResponseEntity.ok(updatedStudent);
	    }
	    
	    
	    private Student gettotal(Student student){
	    	int total = student.getTamil()+student.getEnglish()+student.getMaths()+student.getPhysics()+student.getSocialscience();
	    	student.setTotal(total);
	    	//float flo = (float)(total*100/500);
	    	 student.setPercentage((float)(total*100 / 500));
	    	return student;
	    }

	    @DeleteMapping("/students/{id}")
	    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") int studentId)
	         throws ResourceNotFoundException {
	        Student student = studentRepository.findById(studentId)
	       .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

	        studentRepository.delete(student);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}

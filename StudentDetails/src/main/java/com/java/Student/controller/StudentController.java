package com.java.Student.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.Student.DAO.Student;
import com.java.Student.service.StudentService;

//here it combines the controller and response body which can respond to HTTP requests with data
@RestController

//it sets a base URL for all the methods in the class
@RequestMapping("/Details")
public class StudentController 
{
	//which is used to injecting the constructor of the method
	@Autowired
	private StudentService service;
	
	//which is used to map the HTTP GET requests to a specific handler method
	@GetMapping("/alldata")
	//used to get all the student details 
	public List<Student> getallstudents()
	{
		return service.getall();
	}
	//which is used to map the HTTP GET requests to a specific handler method
	@GetMapping("/details/{id}")
	//used to get the student details by id
	//@PathVariable=it is used for extract from the url and bind the variables for the parameter of the method
	public Student getstudentbyid(@PathVariable("id") int id)
	{
		return service.getbyid(id);
	}
	//which is used to map the HTTP POST requests to a specific handler method
	@PostMapping("/savestudent")
	//used to save the details of the student
	//@RequestBody=It is used to bind the HTTP Request body to the my model parameter
	public String savestudent(@RequestBody Student student)
	{
		service.saveStudent(student);
		return "Saved Successfully with "+student.getId()+" !!";
	}
	//which is used to map HTTP PUT requests to a specific handler method
	@PutMapping("/update/{id}")
	//used to update the details of the student with id
	//@PathVariable=it is used for extract from the URL and bind the variables for the parameter of the method
	//@RequestBody=It is used to bind the HTTP request body to the my model parameter
	public String updatestudent(@PathVariable int id ,@RequestBody Student student)
	{
		student.setId(id);
		service.updateStudent(student);
		return "Updated Details of "+id+" !!";
	}
	//which is used to map HTTP DELETE requests to a specific handler method
	@DeleteMapping("/delete/{id}")
	//@PathVariable=it is used for extract from the URL and bind the variables for the parameter of the method
	public String deleteStudent(@PathVariable int id)
	{
		service.deleteStudent(id);
		return "Deleted of "+id+" !!";
	}
	

}

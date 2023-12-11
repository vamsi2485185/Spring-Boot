package com.java.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.Student.DAO.Student;
import com.java.Student.DAO.StudentRepo;

//by this it will automatically detect and register the class during component scanning
@Service
public class StudentService 
{
	//it will automatically use the constructor for the injection
	@Autowired
	private StudentRepo repo;
	
	public List<Student> getall()
	{
		return repo.findAll();
	}
	public Student getbyid(int id)
	{
		return repo.findById(id);
	}
	public void saveStudent(Student student)
	{
		repo.save(student);
	}
	public void updateStudent(Student student)
	{
		repo.update(student);
	}
	public void deleteStudent(int id)
	{
		repo.delete(id);
	}

}

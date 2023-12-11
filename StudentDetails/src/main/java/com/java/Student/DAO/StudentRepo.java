package com.java.Student.DAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class StudentRepo 
{
	//it will automatically use the constructor for the injection
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<Student> findAll()
	{
		String sql="SELECT * FROM Student";
		return jdbc.query(sql, (rs,rowNum)->
		{
			Student student=new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setPlace(rs.getString("place"));
			student.setEmail(rs.getString("email"));
			return student;
		});
	}
	public Student findById(int id)
	{
		String sql="SELECT * FROM Student WHERE id=?";
		return jdbc.queryForObject(sql,new Object[] {id},(rs,rowNum)->
		{
			Student student=new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setPlace(rs.getString("place"));
			student.setEmail(rs.getString("email"));
			return student;		
		});
	}
	
	public void save(Student student)
	{
		String sql="INSERT INTO Student (name,place,email) VALUES(?,?,?)";
		jdbc.update(sql,student.getName(),student.getPlace(),student.getEmail());
	}
	
	public void update(Student student)
	{
		String sql="UPDATE Student SET name =? ,place=?,email=? WHERE id =?";
		jdbc.update(sql,student.getName(),student.getPlace(),student.getEmail());
	}
	
	public void delete(int id)
	{
		String sql="DELETE FROM Student WHERE id=?";
		jdbc.update(sql,id);
	}
	

}

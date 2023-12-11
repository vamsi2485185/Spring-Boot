package com.java.Student.DAO;

public class Student 
{
//	@Id
//	//this is @id declares that id is primary key
//	@GeneratedValue(strategy=GenerationType.AUTO)
	//used for auto generation of the id which increments it by adding plus one
	private int id;
	private String name;
	private String place;
	private String email;
	//constructor with parameters
	public Student(int id, String name, String place, String email) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.email = email;
	}
	//no parameter constructor
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	//setters and getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//Unimplemented methods can be implement here using override 
	@Override
	//To string is used to display the format of the data in the web
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", place=" + place + ", email=" + email + "]";
	}
	
}

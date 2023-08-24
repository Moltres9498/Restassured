package com.restassured.pojoclass;

public class Serialization_PojoClass {

	String name;
	String email;
	int age;
	int contact;
	
	public Serialization_PojoClass(String name, String email, int age, int contact) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.contact = contact;
	}
	
	public Serialization_PojoClass() {	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}	
}
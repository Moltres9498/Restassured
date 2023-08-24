package com.restassured.pojoclass;

public class Complex_Paring_PojoClass {

	String [] name;
	String email;
	int [] contact;
	int age;
	Spouse_PojoClass spo; 
	
	public Complex_Paring_PojoClass(String[] name, String email, int[] contact, int age, Spouse_PojoClass sp) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.age = age;
		this.spo = sp;
	}

	public Complex_Paring_PojoClass(String[] name, String email, int[] contact, int age) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.age = age;
	}
	
	public Complex_Paring_PojoClass() {	
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int[] getContact() {
		return contact;
	}

	public void setContact(int[] contact) {
		this.contact = contact;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Spouse_PojoClass getSpo() {
		return spo;
	}

	public void setSpo(Spouse_PojoClass spo) {
		this.spo = spo;
	}

	
	
}
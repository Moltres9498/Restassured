package com.restassured.pojoclass;

public class Spouse_PojoClass {
		
		String name;
		String gender;
		int age;
		
		public Spouse_PojoClass(String name, String gender, int age) {
			super();
			this.name = name;
			this.gender = gender;
			this.age = age;
		}
		
		public Spouse_PojoClass() {	
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		
}

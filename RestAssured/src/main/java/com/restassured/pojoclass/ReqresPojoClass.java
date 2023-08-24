package com.restassured.pojoclass;

public class ReqresPojoClass {
	
		String Name;
		String Job;
		
		public ReqresPojoClass(String name, String job) {
			super();
			Name = name;
			Job = job;
		}
		
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getJob() {
			return Job;
		}
		public void setJob(String job) {
			Job = job;
		}
}
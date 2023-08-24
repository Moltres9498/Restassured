package com.restassured.genric;

import org.testng.annotations.DataProvider;

public class Reqres_DataProvider {

	@DataProvider(name = "Data")
	
	public Object[][] Data()
	{
		Object [][] obj=new Object[3][2];
		
		obj[0][0]="nms";
		obj[0][1]="tester";
		
		obj[1][0]="hrm";
		obj[1][1]="devops";
		
		obj[2][0]="estron";
		obj[2][1]="sdet";
		
		return obj;	
	}	
}
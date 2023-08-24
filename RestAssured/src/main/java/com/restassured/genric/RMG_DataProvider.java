package com.restassured.genric;

import org.testng.annotations.DataProvider;

public class RMG_DataProvider {

	@DataProvider(name="getData")
	public Object[ ][ ] getData()
	{
		Object[ ] [ ] data=new Object[3] [4];
		
		data[0][0]="nms";
		data[0][1]="hrm";
		data[0][2]="done";
		data[0][3]=5;
		
		data[1][0]="nms123";
		data[1][1]="hrmestron";
		data[1][2]="doneok";
		data[1][3]=6;
		
		data[2][0]="nms465";
		data[2][1]="hrmrmg";
		data[2][2]="donecomp";
		data[2][3]=7;
		
		return data;
	}	
}
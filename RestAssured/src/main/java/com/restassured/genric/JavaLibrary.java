package com.restassured.genric;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaLibrary {
	
	Date dateObj = new Date();
	SimpleDateFormat sim = new SimpleDateFormat("MM/dd/yyyy");
	
/**
 * This method will return the random number
 * @author Madhu
 * @return
 */
	public int GetRandomNumber() {
		Random ran = new Random();
		int randomnum = ran.nextInt(1000);
		return randomnum;
	}
	
	public String getDate() {

		String date = sim.format(dateObj);
		return date;
	}

	/**
	 * used to get the required date in "yyyy-MM-dd " 
	 * format requiredDateCount is positive number , it provides upcoming date based numeric count
	 * if requiredDateCount is negative number , it provides previous date based numeric count
	 * 
	 * @param requiredDateCount
	 */
	public String getDate(int requiredDateCount) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, requiredDateCount);
		Date date = cal.getTime();
		String rdata = sim.format(date);
		return rdata;
	}

}
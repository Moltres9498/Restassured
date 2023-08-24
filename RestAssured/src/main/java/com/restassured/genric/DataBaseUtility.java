package com.restassured.genric;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
/**
 * used to connect to Db & perform DB specific Operations
 * @author Deepak
 *
 */
public class DataBaseUtility {
	 Driver driver;
	 Connection con;
	 ResultSet result;
    FileUtlity fLib = new FileUtlity();
    String URL;
    String USERNAME;
    String PASSWORD;

	 public DataBaseUtility() throws Throwable{
			String filepath = fLib.getFilePathFromPropertiesFile("databaseConfigFilePath");
			URL = fLib.getDataFromProperties(filepath, "url");
			USERNAME = fLib.getDataFromProperties(filepath, "username");
			PASSWORD = fLib.getDataFromProperties(filepath, "password");
	 }
	
	/**
	 * This method will perform the mysql database connection
	 * @throws SQLException 
	 */
	public void connectDB() throws SQLException {
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will close the mysql database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		try {
		  con.close();
		}catch (Exception e) {
		}


	}
	/**
	 * This method will execute the querry
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet execyteQuery(String query) throws Throwable {	
			result = con.createStatement().executeQuery(query);
			return result;		
	}
	
	/**
	 * This method will execute the querry
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public int execyteUpdate(String query) throws Throwable {
		
			int result = con.createStatement().executeUpdate(query);
	
		return result;

	}
	/**
	 * This method will execute querry based on querry and it will verify the data. 
	 * @param querry
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public String executeQuerryAndVerify(String querry,int cloumnIndex,String expectedData) throws Throwable {
		try {
			boolean flag=false;
			result=con.createStatement().executeQuery(querry);
			while(result.next()) {
				if(result.getString(cloumnIndex).equals(expectedData)) {
					flag=true;
					break;
				}
			}
			if(flag) {
				System.out.println(expectedData+"==>Data is verified in the data base table");
				return expectedData ;
			}else {
				System.out.println(expectedData+"==>data is not verified in the database");
				return "";
			}    
		} catch (Exception e) {
		
		}
		return expectedData;
	}
}
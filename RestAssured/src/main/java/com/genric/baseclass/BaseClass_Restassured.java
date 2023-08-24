package com.genric.baseclass;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.restassured.genric.DataBaseUtility;
import com.restassured.genric.FileUtlity;
import com.restassured.genric.Icredentials;
import com.restassured.genric.WebActionUtility;
import com.restassured.pomclass.HomePage_Rmg;
import com.restassured.pomclass.Login_Rmg;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_Restassured{

public WebDriver driver;
//	FileUtlity fLib = new FileUtlity();	
//	Login_Rmg lp=new Login_Rmg(driver);
//
//	@BeforeSuite
//	public void connect() throws Throwable {
//		DataBaseUtility db=new DataBaseUtility();
//		db.connectDB();
//	}
	
	@BeforeClass
	public void openbrowser() throws Throwable {
	
//		String BROWSER = "Chrome";
//		if(BROWSER.equals("Chrome")) {		
//			driver = new ChromeDriver();
//		}else if(BROWSER.equals("Firefox")) {
//			driver = new FirefoxDriver();
//		}else if(BROWSER.equals("Edge")) {
//			driver = new EdgeDriver();
//		}else {
			driver = new ChromeDriver();
//		}
	//	driver.manage().window().maximize();
		String URL = Icredentials.URL;
		driver.get(URL);
	}

//	@BeforeMethod
//	public void login() throws Throwable {
//		String EMAIL = Icredentials.appUN;
//		String PASSWORd =Icredentials.appPW;
//		lp.loginToApp(EMAIL, PASSWORd);
////		String ENV_FILE_PATH =    fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
////		String EMAIL = fLib.getDataFromProperties(ENV_FILE_PATH, "Email");
////		String PASSWORd = fLib.getDataFromProperties(ENV_FILE_PATH, "password");
////		Login_Rmg lp = new Login_Rmg(driver);
////		lp.loginToApp(EMAIL, PASSWORd);
//	}
//
//	@AfterMethod
//	public void logout() {
//		HomePage_Rmg hp=new HomePage_Rmg(driver);
//		hp.logout();
//	}
//
//	@AfterClass
//	public void CloseBrowser() {
//		driver.quit();
//	}
//
//	@AfterSuite
//	public void closeconn() throws Throwable {
//		DataBaseUtility db=new DataBaseUtility();
//		db.closeDB();
//	}

}

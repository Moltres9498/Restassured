package com.genric.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.restassured.genric.DataBaseUtility;
import com.restassured.genric.FileUtlity;
import com.restassured.genric.Icredentials;
import com.restassured.genric.JavaLibrary;
import com.restassured.genric.RestAssured_Library;
import com.restassured.genric.WebActionUtility;
import com.restassured.pomclass.HomePage_Rmg;
import com.restassured.pomclass.Login_Rmg;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClassForAPI{
	FileUtlity fLib=new FileUtlity();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public JavaLibrary jlib=new JavaLibrary();
	public RestAssured_Library rlib=new RestAssured_Library();
	public String URL=null;
	
	@BeforeSuite
	   public void connectToDB() throws Throwable {
		DataBaseUtility dlib=new DataBaseUtility();
		dlib.connectDB();
		Reporter.log("------------------CONNECTED TO DATABASE----------------",true);
	}
	
	@BeforeClass
	public void lanchBrowser() throws Throwable {
		String URL = Icredentials.URL;
		String BROWSER = "Chrome";
		if(BROWSER.equals("Chrome")) {	
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(BROWSER.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		sdriver=driver;
	}
	
	@BeforeMethod
	public void  loginToApplication() throws Throwable {
		Login_Rmg lp=new Login_Rmg(driver);
		String USERNAME = Icredentials.appUN;
		String PASSWORD = Icredentials.appPW;
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("  login to the Application...............",true);
	}
	
//	@AfterMethod
//	public void logoutFromApplication() throws InterruptedException {
//		HomePage_Rmg hp=new HomePage_Rmg(driver);
//		hp.getLgoutbtn().click();
//		Reporter.log("  LOgOuting from the Application ...............",true);
//	}
	
//	@AfterClass
//	public void closeTheBrowser() {
//		driver.quit();
//		Reporter.log("  BROWSER Closed................",true);
//	}
	
//	@AfterSuite
//	 public void closeConnectionToDB() throws Throwable {
//		DataBaseUtility dlib=new DataBaseUtility();
//		dlib.closeDB();
//		 Reporter.log("------------------DATABASE CLOSED----------------",true);
//			
//		}
}

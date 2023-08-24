package com.restassured.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class Login_Rmg{
	
	@FindBy(id="usernmae")
	private WebElement Emailtxtbox;
	
	@FindBy(id = "inputPassword")
	private WebElement passwordtxtbox;
	
	@FindBy(xpath="//button[.='Sign in']")
	private WebElement Loginbtn;
	
	public Login_Rmg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApp(String EMAIL,String PASSWORD) throws Throwable
	{
		Emailtxtbox.sendKeys(EMAIL);
		passwordtxtbox.sendKeys(PASSWORD);
		Loginbtn.click();
		Reporter.log("Logged in Successfully", true);
	}
}
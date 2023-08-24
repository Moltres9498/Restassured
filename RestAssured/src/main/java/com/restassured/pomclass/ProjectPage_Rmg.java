package com.restassured.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.restassured.genric.WebActionUtility;

public class ProjectPage_Rmg {
	
	@FindBy(xpath="//span[.='Create Project']")
	private WebElement createprjbtn;

	@FindBy(xpath="//input[@name='projectName']")
	private WebElement rmgprjname;

	@FindBy(xpath="//input[@name='createdBy']")
	private WebElement prjmanager;
	
	@FindBy(xpath="//div[@class='ReactModal__Content ReactModal__Content--after-open']//select[@name='status']")
	private WebElement statusdrp;
	
	@FindBy(xpath="//input[@value='Add Project']")
	private WebElement addprojbtn;
	
	public ProjectPage_Rmg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void CreateProject(String prjname, String prjmnname) throws Throwable {
		WebActionUtility wlib=new WebActionUtility();
		createprjbtn.click();
		rmgprjname.sendKeys(prjname);
		prjmanager.sendKeys(prjmnname);
		wlib.select(statusdrp, 3);
		addprojbtn.click();
	}
}
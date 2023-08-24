package com.restassured.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Rmg {
@FindBy(linkText ="Projects")
private WebElement prjcts;

@FindBy(xpath = "//span[text()='Create Project']")
private WebElement crtprjct;

@FindBy(name = "projectName")
private WebElement prjname;

@FindBy(name = "createdBy")
private WebElement prjmanagr;

@FindBy(name = "status")
private WebElement selectvalue;
//input[@class='btn btn-success']

@FindBy(xpath = "//input[@class='btn btn-success']")
private WebElement addprj;

public HomePage_Rmg(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getPrjcts() {
	return prjcts;
}

public WebElement getCrtprjct() {
	return crtprjct;
}

public WebElement getPrjname() {
	return prjname;
}

public WebElement getPrjmanagr() {
	return prjmanagr;
}

public WebElement getSelectvalue() {
	return selectvalue;
}

public WebElement getAddprj() {
	return addprj;
}



}

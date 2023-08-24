package End_To_End_Scenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.genric.baseclass.BaseClassForAPI;
import com.restassured.genric.ExcelUtlity;
import com.restassured.genric.JavaLibrary;
import com.restassured.genric.WebActionUtility;
import com.restassured.pomclass.HomePage_Rmg;
import com.restassured.pomclass.ProjectPage_Rmg;

public class Create_Update_Validate extends BaseClassForAPI{
	
	public WebDriver driver;
	
	@Test
	
	public void EndToEnd() throws IOException, Throwable {

//		HomePage_Rmg hp=new HomePage_Rmg(driver);
//		ProjectPage_Rmg pg=new ProjectPage_Rmg(driver);
//		ExcelUtlity eutil=new ExcelUtlity();
//		WebActionUtility wlib=new WebActionUtility();
//		JavaLibrary jlib=new JavaLibrary();
		
		
	//	String PrjName=eutil.getDataFromExcel("./src/test/resources/rmg_data.xlsx", "Data", 1, 0);
	//	String MnName=eutil.getDataFromExcel("./src/test/resources/rmg_data.xlsx", "Data", 1, 1);
		
		//String PrjName="hrm";
		//String MnName="madhu";
		
		//wlib.waitForElementInDOM(driver);
//		Thread.sleep(2000);
//		System.out.println("its faliing before hp");
//		Thread.sleep(3000);
//		hp.getPrjcts().click();
//		System.out.println("its faliing after hp");
//		Thread.sleep(2000);
//		System.out.println("its faliing before pg");
		//pg.CreateProject(PrjName+jlib.GetRandomNumber(), MnName);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Projects")).click();
		
	}

}
